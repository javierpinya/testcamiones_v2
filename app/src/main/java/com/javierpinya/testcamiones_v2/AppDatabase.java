package com.javierpinya.testcamiones_v2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.javierpinya.testcamiones_v2.Clases.InspeccionEntity;
import com.javierpinya.testcamiones_v2.Clases.TaccamiEntity;
import com.javierpinya.testcamiones_v2.Clases.TaccatrEntity;
import com.javierpinya.testcamiones_v2.Clases.TaccondEntity;
import com.javierpinya.testcamiones_v2.Clases.TacprcoEntity;
import com.javierpinya.testcamiones_v2.Clases.TacsecoEntity;
import com.javierpinya.testcamiones_v2.Clases.TplcprtEntity;
import com.javierpinya.testcamiones_v2.Clases.UsuarioEntity;
import com.javierpinya.testcamiones_v2.Converters.Converters;
import com.javierpinya.testcamiones_v2.Dao.InspeccionDao;
import com.javierpinya.testcamiones_v2.Dao.TaccamiDao;
import com.javierpinya.testcamiones_v2.Dao.TaccatrDao;
import com.javierpinya.testcamiones_v2.Dao.TaccondDao;
import com.javierpinya.testcamiones_v2.Dao.TacprcoDao;
import com.javierpinya.testcamiones_v2.Dao.TacsecoDao;
import com.javierpinya.testcamiones_v2.Dao.TplcprtDao;
import com.javierpinya.testcamiones_v2.Dao.UsuarioDao;

@Database(entities = {UsuarioEntity.class, TaccamiEntity.class, TacprcoEntity.class, TacsecoEntity.class, InspeccionEntity.class, TaccatrEntity.class, TaccondEntity.class, TplcprtEntity.class}, version = 2, exportSchema = false)

@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract UsuarioDao usuarioDao();
    public abstract TaccamiDao taccamiDao();
    public abstract InspeccionDao inspeccionDao();
    public abstract TacprcoDao tacprcoDao();
    public abstract TacsecoDao tacsecoDao();
    public abstract TaccatrDao taccatrDao();
    public abstract TaccondDao taccondDao();
    public abstract TplcprtDao tplcprtDao();


    private static volatile AppDatabase INSTANCE;



    public static AppDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (AppDatabase.class){

                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "usuario_database")
                            .allowMainThreadQueries()
                            .build();
                    //                            .addMigrations(MIGRATION_1_2)
                }
            }
        }
        return INSTANCE;
    }


    public static void destroyInstance(){ INSTANCE = null; }

    /*
    static final Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE " + Constants.NAME_TABLE_TPLCPRT + " (id INTEGER PRIMARY KEY NOT NULL," +
                    "cod_compartimento INTEGER DEFAULT 0, id_tipo_componente INTEGER DEFAULT 0," +
                    "cisternaId INTEGER NOT NULL, can_capacidad INTEGER DEFAULT 0, cod_tag_cprt TEXT," +
                    "foreign key (cisternaId) references " + Constants.NAME_TABLE_TACSECO +
                    "(id) ON DELETE CASCADE)");
            database.execSQL("CREATE UNIQUE INDEX index_" + Constants.NAME_TABLE_TPLCPRT + "_cisternaId ON " + Constants.NAME_TABLE_TPLCPRT + "(cisternaId)");
            database.execSQL("CREATE UNIQUE INDEX index_" + Constants.NAME_TABLE_TPLCPRT + "_id ON " + Constants.NAME_TABLE_TPLCPRT + "(id)");
        }
    };

    static final Migration MIGRATION_2_3 = new Migration(2,3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE vehiculo (id INTEGER PRIMARY KEY NOT NULL," +
                    "tMatricula TEXT, tTipo TEXT, tInspeccionada INTEGER DEFAULT 0, tBloqueada INTEGER DEFAULT 0," +
                    "cMatricula TEXT, cInspeccionada INTEGER DEFAULT 0, cBloqueada INTEGER DEFAULT 0)");
        }
    };

    static final Migration MIGRATION_3_4 = new Migration(3,4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("DROP TABLE vehiculo");
            database.execSQL("CREATE TABLE " + Constants.NAME_TABLE_TACCAMI + " (id INTEGER PRIMARY KEY NOT NULL," +
                    "cod_vehiculo INTEGER NOT NULL, tractoraId INTEGER NOT NULL," +
                    "cisternaId INTEGER NOT NULL, tara INTEGER NOT NULL , pesoMaximo INTEGER NOT NULL," +
                    "fec_baja INTEGER, foreign key (cisternaId) references " + Constants.NAME_TABLE_TACSECO +
                    "(id) ON DELETE CASCADE, foreign key (tractoraId) references " + Constants.NAME_TABLE_TACPRCO +
                    "(id) ON DELETE CASCADE)");
            database.execSQL("CREATE UNIQUE INDEX index_" + Constants.NAME_TABLE_TACCAMI + "_tractoraId ON " + Constants.NAME_TABLE_TACCAMI + "(tractoraId)" );
            database.execSQL("CREATE UNIQUE INDEX index_" + Constants.NAME_TABLE_TACCAMI + "_cisternaId ON " + Constants.NAME_TABLE_TACCAMI + "(cisternaId)" );
            database.execSQL("CREATE UNIQUE INDEX index_" + Constants.NAME_TABLE_TACCAMI + "_id ON " + Constants.NAME_TABLE_TACCAMI + "(id)" );

            database.execSQL("CREATE TABLE " + Constants.NAME_TABLE_TACPRCO + " (id INTEGER PRIMARY KEY NOT NULL," +
                    "matricula TEXT, fec_cadu_itv INTEGER, fec_cadu_adr INTEGER, tara INTEGER NOT NULL, peso_maximo INTEGER NOT NULL," +
                    "chip INTEGER NOT NULL, tipo TEXT, fec_baja INTEGER, solo_gasoleos INTEGER NOT NULL," +
                    "ind_bloqueo INTEGER NOT NULL, ind_queroseno INTEGER NOT NULL, cod_nacion TEXT)");
            database.execSQL("CREATE UNIQUE INDEX index_" + Constants.NAME_TABLE_TACPRCO+ "_id ON " + Constants.NAME_TABLE_TACPRCO + "(id)");

            database.execSQL("CREATE TABLE " + Constants.NAME_TABLE_TACSECO + " (id INTEGER PRIMARY KEY NOT NULL," +
                    "matricula TEXT, fec_cadu_itv INTEGER, fec_cadu_adr INTEGER, tara INTEGER NOT NULL, peso_maximo INTEGER NOT NULL," +
                    "chip INTEGER NOT NULL, tipo TEXT, fec_cadu_calibracion INTEGER, num_ejes INTEGER NOT NULL," +
                    "ind_carga_pesados INTEGER NOT NULL, fec_baja INTEGER, cod_nacion TEXT, solo_gasoleos INTEGER NOT NULL," +
                    "ind_bloqueo INTEGER NOT NULL, ind_queroseno INTEGER NOT NULL)");
            database.execSQL("CREATE UNIQUE INDEX index_" + Constants.NAME_TABLE_TACSECO+ "_id ON " + Constants.NAME_TABLE_TACSECO + "(id)");

            database.execSQL("CREATE TABLE " + Constants.NAME_TABLE_TACCOND + " (id INTEGER PRIMARY KEY NOT NULL," +
                    "cod_conductor TEXT, id_tipo_documeto TEXT, dni TEXT, nombre TEXT, apellidos TEXT," +
                    "fec_cadu_perm_conduccion INTEGER, fec_cadu_adr INTEGER, fec_inic_bloqueo INTEGER, fec_fin_bloqueo INTEGER," +
                    "tipo_autorizacion TEXT, ind_empleado TEXT)");
            database.execSQL("CREATE UNIQUE INDEX index_" + Constants.NAME_TABLE_TACCOND+ "_id ON " + Constants.NAME_TABLE_TACCOND + "(id)");

            database.execSQL("CREATE TABLE " + Constants.NAME_TABLE_TACCATR + " (id INTEGER PRIMARY KEY NOT NULL," +
                    "vehiculoId INTEGER NOT NULL, transportista TEXT, slo TEXT, fec_baja INTEGER, foreign key (vehiculoId)" +
                    "references " + Constants.NAME_TABLE_TACCAMI + "(id) ON DELETE CASCADE)");
            database.execSQL("CREATE UNIQUE INDEX index_" + Constants.NAME_TABLE_TACCATR + "_id ON " + Constants.NAME_TABLE_TACCATR + "(id)");
            database.execSQL("CREATE UNIQUE INDEX index_" + Constants.NAME_TABLE_TACCATR + "_vehiculoId ON " + Constants.NAME_TABLE_TACCATR + "(vehiculoId)");

            database.execSQL("CREATE TABLE " + Constants.NAME_TABLE_INSPECCION +
                    "(id INTEGER PRIMARY KEY NOT NULL," +
                    "inspeccion TEXT," +
                    "inspector TEXT," +
                    "instalacion TEXT," +
                    "tractoraId INTEGER NOT NULL," +
                    "cisternaId INTEGER NOT NULL," +
                    "fechaInicioInspeccion INTEGER," +
                    "albaran TEXT," +
                    "conductorId INTEGER NOT NULL," +
                    "transportistaId INTEGER NOT NULL," +
                    "empresaTablaCalibracion TEXT," +
                    "tipoComponente TEXT," +
                    "observaciones TEXT," +
                    "fechaFinInspeccion INTEGER," +
                    "isPermisoConducir INTEGER NOT NULL," +
                    "isAdrConductor INTEGER NOT NULL," +
                    "isItvTractora INTEGER NOT NULL," +
                    "isAdrTractora INTEGER NOT NULL," +
                    "isItvCisterna INTEGER NOT NULL," +
                    "isAdrCisterna INTEGER NOT NULL," +
                    "isFichaSeguridad INTEGER NOT NULL," +
                    "fechaTablaCalibracion INTEGER," +
                    "isTChip INTEGER NOT NULL," +
                    "isCChip INTEGER NOT NULL," +
                    "isSuperficieAntideslizante INTEGER NOT NULL," +
                    "isCFavorable INTEGER NOT NULL," +
                    "isPosicionamientoAdecuadoEnIsleta INTEGER NOT NULL," +
                    "isAccFrenoEstacionamientoMarchaCorta INTEGER NOT NULL," +
                    "isAccDesBaterias INTEGER NOT NULL," +
                    "isApagallamas INTEGER NOT NULL," +
                    "isDescTfnoMovil INTEGER NOT NULL," +
                    "isInterruptorEmergenciaYFuego  INTEGER NOT NULL," +
                    "isConexionTomaTierra INTEGER NOT NULL," +
                    "isConexionMangueraGases INTEGER NOT NULL," +
                    "isPurgaCompartimentos INTEGER NOT NULL," +
                    "isRopaSeguridad INTEGER NOT NULL," +
                    "isEstanqueidadCisterna INTEGER NOT NULL," +
                    "isEstanqueidadValvulasApi INTEGER NOT NULL," +
                    "isEstanqueidadCajon INTEGER NOT NULL," +
                    "isRecogerAlbaran INTEGER NOT NULL," +
                    "isTC2 INTEGER NOT NULL," +
                    "isMontajeCorrectoTags INTEGER NOT NULL," +
                    "isBajadaTagPlanta INTEGER NOT NULL," +
                    "isLecturaTagIsleta INTEGER NOT NULL," +
                    "isTInspeccionada INTEGER NOT NULL," +
                    "isTFavorable INTEGER NOT NULL," +
                    "isTRevisada INTEGER NOT NULL," +
                    "isTBloqueada INTEGER NOT NULL," +
                    "isCinspeccionada INTEGER NOT NULL," +
                    "isCRevisada INTEGER NOT NULL," +
                    "isCBloqueada INTEGER NOT NULL," +

                    "foreign key (tractoraId) references " + Constants.NAME_TABLE_TACPRCO + "(id)," +
                    "foreign key (cisternaId) references " + Constants.NAME_TABLE_TACSECO + "(id)," +
                    "foreign key (transportistaId) references " + Constants.NAME_TABLE_TACCATR + "(id)," +
                    "foreign key (conductorId) references " + Constants.NAME_TABLE_TACCOND + "(id))");
            database.execSQL("CREATE UNIQUE INDEX index_" + Constants.NAME_TABLE_INSPECCION + "_id ON " + Constants.NAME_TABLE_INSPECCION + "(id)");
            database.execSQL("CREATE UNIQUE INDEX index_" + Constants.NAME_TABLE_INSPECCION + "_tractoraId ON " + Constants.NAME_TABLE_INSPECCION + "(tractoraId)");
            database.execSQL("CREATE UNIQUE INDEX index_" + Constants.NAME_TABLE_INSPECCION + "_cisternaId ON " + Constants.NAME_TABLE_INSPECCION + "(cisternaId)");
            database.execSQL("CREATE UNIQUE INDEX index_" + Constants.NAME_TABLE_INSPECCION + "_transportistaId ON " + Constants.NAME_TABLE_INSPECCION + "(transportistaId)");
            database.execSQL("CREATE UNIQUE INDEX index_" + Constants.NAME_TABLE_INSPECCION + "_conductorId ON " + Constants.NAME_TABLE_INSPECCION + "(conductorId)");


        }
    };

     */
}
