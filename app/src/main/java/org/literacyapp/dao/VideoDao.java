package org.literacyapp.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import java.util.Calendar;
import java.util.Set;
import org.literacyapp.dao.converter.CalendarConverter;
import org.literacyapp.dao.converter.ContentStatusConverter;
import org.literacyapp.dao.converter.LocaleConverter;
import org.literacyapp.dao.converter.StringSetConverter;
import org.literacyapp.dao.converter.VideoFormatConverter;
import org.literacyapp.model.enums.Locale;
import org.literacyapp.model.enums.content.ContentStatus;
import org.literacyapp.model.enums.content.VideoFormat;

import org.literacyapp.dao.Video;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "VIDEO".
*/
public class VideoDao extends AbstractDao<Video, Long> {

    public static final String TABLENAME = "VIDEO";

    /**
     * Properties of entity Video.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Locale = new Property(1, String.class, "locale", false, "LOCALE");
        public final static Property TimeLastUpdate = new Property(2, Long.class, "timeLastUpdate", false, "TIME_LAST_UPDATE");
        public final static Property RevisionNumber = new Property(3, Integer.class, "revisionNumber", false, "REVISION_NUMBER");
        public final static Property ContentStatus = new Property(4, String.class, "contentStatus", false, "CONTENT_STATUS");
        public final static Property FileUrl = new Property(5, String.class, "fileUrl", false, "FILE_URL");
        public final static Property FileSize = new Property(6, Integer.class, "fileSize", false, "FILE_SIZE");
        public final static Property ContentType = new Property(7, String.class, "contentType", false, "CONTENT_TYPE");
        public final static Property AttributionUrl = new Property(8, String.class, "attributionUrl", false, "ATTRIBUTION_URL");
        public final static Property LiteracySkills = new Property(9, String.class, "literacySkills", false, "LITERACY_SKILLS");
        public final static Property NumeracySkills = new Property(10, String.class, "numeracySkills", false, "NUMERACY_SKILLS");
        public final static Property Title = new Property(11, String.class, "title", false, "TITLE");
        public final static Property VideoFormat = new Property(12, String.class, "videoFormat", false, "VIDEO_FORMAT");
    };

    private final LocaleConverter localeConverter = new LocaleConverter();
    private final CalendarConverter timeLastUpdateConverter = new CalendarConverter();
    private final ContentStatusConverter contentStatusConverter = new ContentStatusConverter();
    private final StringSetConverter literacySkillsConverter = new StringSetConverter();
    private final StringSetConverter numeracySkillsConverter = new StringSetConverter();
    private final VideoFormatConverter videoFormatConverter = new VideoFormatConverter();

    public VideoDao(DaoConfig config) {
        super(config);
    }
    
    public VideoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"VIDEO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"LOCALE\" TEXT," + // 1: locale
                "\"TIME_LAST_UPDATE\" INTEGER," + // 2: timeLastUpdate
                "\"REVISION_NUMBER\" INTEGER," + // 3: revisionNumber
                "\"CONTENT_STATUS\" TEXT," + // 4: contentStatus
                "\"FILE_URL\" TEXT," + // 5: fileUrl
                "\"FILE_SIZE\" INTEGER," + // 6: fileSize
                "\"CONTENT_TYPE\" TEXT," + // 7: contentType
                "\"ATTRIBUTION_URL\" TEXT," + // 8: attributionUrl
                "\"LITERACY_SKILLS\" TEXT," + // 9: literacySkills
                "\"NUMERACY_SKILLS\" TEXT," + // 10: numeracySkills
                "\"TITLE\" TEXT," + // 11: title
                "\"VIDEO_FORMAT\" TEXT);"); // 12: videoFormat
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"VIDEO\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Video entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Locale locale = entity.getLocale();
        if (locale != null) {
            stmt.bindString(2, localeConverter.convertToDatabaseValue(locale));
        }
 
        Calendar timeLastUpdate = entity.getTimeLastUpdate();
        if (timeLastUpdate != null) {
            stmt.bindLong(3, timeLastUpdateConverter.convertToDatabaseValue(timeLastUpdate));
        }
 
        Integer revisionNumber = entity.getRevisionNumber();
        if (revisionNumber != null) {
            stmt.bindLong(4, revisionNumber);
        }
 
        ContentStatus contentStatus = entity.getContentStatus();
        if (contentStatus != null) {
            stmt.bindString(5, contentStatusConverter.convertToDatabaseValue(contentStatus));
        }
 
        String fileUrl = entity.getFileUrl();
        if (fileUrl != null) {
            stmt.bindString(6, fileUrl);
        }
 
        Integer fileSize = entity.getFileSize();
        if (fileSize != null) {
            stmt.bindLong(7, fileSize);
        }
 
        String contentType = entity.getContentType();
        if (contentType != null) {
            stmt.bindString(8, contentType);
        }
 
        String attributionUrl = entity.getAttributionUrl();
        if (attributionUrl != null) {
            stmt.bindString(9, attributionUrl);
        }
 
        Set literacySkills = entity.getLiteracySkills();
        if (literacySkills != null) {
            stmt.bindString(10, literacySkillsConverter.convertToDatabaseValue(literacySkills));
        }
 
        Set numeracySkills = entity.getNumeracySkills();
        if (numeracySkills != null) {
            stmt.bindString(11, numeracySkillsConverter.convertToDatabaseValue(numeracySkills));
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(12, title);
        }
 
        VideoFormat videoFormat = entity.getVideoFormat();
        if (videoFormat != null) {
            stmt.bindString(13, videoFormatConverter.convertToDatabaseValue(videoFormat));
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Video readEntity(Cursor cursor, int offset) {
        Video entity = new Video( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : localeConverter.convertToEntityProperty(cursor.getString(offset + 1)), // locale
            cursor.isNull(offset + 2) ? null : timeLastUpdateConverter.convertToEntityProperty(cursor.getLong(offset + 2)), // timeLastUpdate
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // revisionNumber
            cursor.isNull(offset + 4) ? null : contentStatusConverter.convertToEntityProperty(cursor.getString(offset + 4)), // contentStatus
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // fileUrl
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // fileSize
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // contentType
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // attributionUrl
            cursor.isNull(offset + 9) ? null : literacySkillsConverter.convertToEntityProperty(cursor.getString(offset + 9)), // literacySkills
            cursor.isNull(offset + 10) ? null : numeracySkillsConverter.convertToEntityProperty(cursor.getString(offset + 10)), // numeracySkills
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // title
            cursor.isNull(offset + 12) ? null : videoFormatConverter.convertToEntityProperty(cursor.getString(offset + 12)) // videoFormat
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Video entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setLocale(cursor.isNull(offset + 1) ? null : localeConverter.convertToEntityProperty(cursor.getString(offset + 1)));
        entity.setTimeLastUpdate(cursor.isNull(offset + 2) ? null : timeLastUpdateConverter.convertToEntityProperty(cursor.getLong(offset + 2)));
        entity.setRevisionNumber(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setContentStatus(cursor.isNull(offset + 4) ? null : contentStatusConverter.convertToEntityProperty(cursor.getString(offset + 4)));
        entity.setFileUrl(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setFileSize(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setContentType(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setAttributionUrl(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setLiteracySkills(cursor.isNull(offset + 9) ? null : literacySkillsConverter.convertToEntityProperty(cursor.getString(offset + 9)));
        entity.setNumeracySkills(cursor.isNull(offset + 10) ? null : numeracySkillsConverter.convertToEntityProperty(cursor.getString(offset + 10)));
        entity.setTitle(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setVideoFormat(cursor.isNull(offset + 12) ? null : videoFormatConverter.convertToEntityProperty(cursor.getString(offset + 12)));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Video entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Video entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
