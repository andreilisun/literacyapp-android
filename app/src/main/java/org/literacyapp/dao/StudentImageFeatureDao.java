package org.literacyapp.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import java.util.Calendar;
import org.literacyapp.dao.converter.CalendarConverter;
import org.literacyapp.model.Student;

import org.literacyapp.model.StudentImageFeature;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "STUDENT_IMAGE_FEATURE".
*/
public class StudentImageFeatureDao extends AbstractDao<StudentImageFeature, Long> {

    public static final String TABLENAME = "STUDENT_IMAGE_FEATURE";

    /**
     * Properties of entity StudentImageFeature.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property TimeCreated = new Property(1, long.class, "timeCreated", false, "TIME_CREATED");
        public final static Property SvmVector = new Property(2, String.class, "svmVector", false, "SVM_VECTOR");
        public final static Property Student = new Property(3, Long.class, "student", false, "STUDENT");
    }

    private DaoSession daoSession;

    private final CalendarConverter timeCreatedConverter = new CalendarConverter();

    public StudentImageFeatureDao(DaoConfig config) {
        super(config);
    }
    
    public StudentImageFeatureDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"STUDENT_IMAGE_FEATURE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"TIME_CREATED\" INTEGER NOT NULL ," + // 1: timeCreated
                "\"SVM_VECTOR\" TEXT NOT NULL ," + // 2: svmVector
                "\"STUDENT\" INTEGER);"); // 3: student
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"STUDENT_IMAGE_FEATURE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, StudentImageFeature entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, timeCreatedConverter.convertToDatabaseValue(entity.getTimeCreated()));
        stmt.bindString(3, entity.getSvmVector());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, StudentImageFeature entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, timeCreatedConverter.convertToDatabaseValue(entity.getTimeCreated()));
        stmt.bindString(3, entity.getSvmVector());
    }

    @Override
    protected final void attachEntity(StudentImageFeature entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public StudentImageFeature readEntity(Cursor cursor, int offset) {
        StudentImageFeature entity = new StudentImageFeature( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            timeCreatedConverter.convertToEntityProperty(cursor.getLong(offset + 1)), // timeCreated
            cursor.getString(offset + 2) // svmVector
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, StudentImageFeature entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTimeCreated(timeCreatedConverter.convertToEntityProperty(cursor.getLong(offset + 1)));
        entity.setSvmVector(cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(StudentImageFeature entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(StudentImageFeature entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(StudentImageFeature entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getStudentDao().getAllColumns());
            builder.append(" FROM STUDENT_IMAGE_FEATURE T");
            builder.append(" LEFT JOIN STUDENT T0 ON T.\"STUDENT\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected StudentImageFeature loadCurrentDeep(Cursor cursor, boolean lock) {
        StudentImageFeature entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Student student = loadCurrentOther(daoSession.getStudentDao(), cursor, offset);
        entity.setStudent(student);

        return entity;    
    }

    public StudentImageFeature loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<StudentImageFeature> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<StudentImageFeature> list = new ArrayList<StudentImageFeature>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<StudentImageFeature> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<StudentImageFeature> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
