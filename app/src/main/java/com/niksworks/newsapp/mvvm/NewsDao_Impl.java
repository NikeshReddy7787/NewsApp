package com.niksworks.newsapp.mvvm;

import android.annotation.SuppressLint;
import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.niksworks.newsapp.db.ClassConvertors;
import com.niksworks.newsapp.db.SavedArticle;
import com.niksworks.newsapp.db.Source;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NewsDao_Impl implements NewsDao {
    private final RoomDatabase __db;

    @SuppressLint("RestrictedApi")
    private final EntityInsertionAdapter<SavedArticle> __insertionAdapterOfSavedArticle;

    private final ClassConvertors __classConvertors = new ClassConvertors();

    private final SharedSQLiteStatement __preparedStmtOfDelteAll;

    @SuppressLint("RestrictedApi")
    public NewsDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfSavedArticle = new EntityInsertionAdapter<SavedArticle>(__db) {
            @Override
            public String createQuery() {
                return "INSERT OR ABORT INTO `NEWSARTICLE` (`id`,`description`,`publishedAt`,`source`,`title`,`url`,`urlToImage`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
            }

            @Override
            public void bind(SupportSQLiteStatement stmt, SavedArticle value) {
                stmt.bindLong(1, value.getId());
                if (value.getDescription() == null) {
                    stmt.bindNull(2);
                } else {
                    stmt.bindString(2, value.getDescription());
                }
                if (value.getPublishedAt() == null) {
                    stmt.bindNull(3);
                } else {
                    stmt.bindString(3, value.getPublishedAt());
                }
                final String _tmp = __classConvertors.fromSource(value.getSource());
                if (_tmp == null) {
                    stmt.bindNull(4);
                } else {
                    stmt.bindString(4, _tmp);
                }
                if (value.getTitle() == null) {
                    stmt.bindNull(5);
                } else {
                    stmt.bindString(5, value.getTitle());
                }
                if (value.getUrl() == null) {
                    stmt.bindNull(6);
                } else {
                    stmt.bindString(6, value.getUrl());
                }
                if (value.getUrlToImage() == null) {
                    stmt.bindNull(7);
                } else {
                    stmt.bindString(7, value.getUrlToImage());
                }
            }
        };
        this.__preparedStmtOfDelteAll = new SharedSQLiteStatement(__db) {
            @Override
            public String createQuery() {
                final String _query = "DELETE FROM NEWSARTICLE";
                return _query;
            }
        };
    }

    @SuppressLint("RestrictedApi")
    @Override
    public Object insertNews(final SavedArticle savedArticle,
                             final Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
            @Override
            public Unit call() throws Exception {
                __db.beginTransaction();
                try {
                    __insertionAdapterOfSavedArticle.insert(savedArticle);
                    __db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    __db.endTransaction();
                }
            }
        }, continuation);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void delteAll() {
        __db.assertNotSuspendingTransaction();
        final SupportSQLiteStatement _stmt = __preparedStmtOfDelteAll.acquire();
        __db.beginTransaction();
        try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
        } finally {
            __db.endTransaction();
            __preparedStmtOfDelteAll.release(_stmt);
        }
    }

    @SuppressLint("RestrictedApi")
    @Override
    public LiveData<List<SavedArticle>> getAllNews() {
        final String _sql = "SELECT * FROM  NEWSARTICLE";
        @SuppressLint("RestrictedApi") final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
        return __db.getInvalidationTracker().createLiveData(new String[]{"NEWSARTICLE"}, false, new Callable<List<SavedArticle>>() {
            @Override
            public List<SavedArticle> call() throws Exception {
                final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
                try {
                    final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                    final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
                    final int _cursorIndexOfPublishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "publishedAt");
                    final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
                    final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
                    final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
                    final int _cursorIndexOfUrlToImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlToImage");
                    final List<SavedArticle> _result = new ArrayList<SavedArticle>(_cursor.getCount());
                    while(_cursor.moveToNext()) {
                        final SavedArticle _item;
                        final int _tmpId;
                        _tmpId = _cursor.getInt(_cursorIndexOfId);
                        final String _tmpDescription;
                        if (_cursor.isNull(_cursorIndexOfDescription)) {
                            _tmpDescription = null;
                        } else {
                            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
                        }
                        final String _tmpPublishedAt;
                        if (_cursor.isNull(_cursorIndexOfPublishedAt)) {
                            _tmpPublishedAt = null;
                        } else {
                            _tmpPublishedAt = _cursor.getString(_cursorIndexOfPublishedAt);
                        }
                        final Source _tmpSource;
                        final String _tmp;
                        if (_cursor.isNull(_cursorIndexOfSource)) {
                            _tmp = null;
                        } else {
                            _tmp = _cursor.getString(_cursorIndexOfSource);
                        }
                        _tmpSource = __classConvertors.toSource(_tmp);
                        final String _tmpTitle;
                        if (_cursor.isNull(_cursorIndexOfTitle)) {
                            _tmpTitle = null;
                        } else {
                            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
                        }
                        final String _tmpUrl;
                        if (_cursor.isNull(_cursorIndexOfUrl)) {
                            _tmpUrl = null;
                        } else {
                            _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
                        }
                        final String _tmpUrlToImage;
                        if (_cursor.isNull(_cursorIndexOfUrlToImage)) {
                            _tmpUrlToImage = null;
                        } else {
                            _tmpUrlToImage = _cursor.getString(_cursorIndexOfUrlToImage);
                        }
                        _item = new SavedArticle(_tmpId,_tmpDescription,_tmpPublishedAt,_tmpSource,_tmpTitle,_tmpUrl,_tmpUrlToImage);
                        _result.add(_item);
                    }
                    return _result;
                } finally {
                    _cursor.close();
                }
            }

            @Override
            protected void finalize() {
                _statement.release();
            }
        });
    }

    @Override
    public LiveData<SavedArticle> getNewsById() {
        final String _sql = "SELECT * FROM NEWSARTICLE";
        @SuppressLint("RestrictedApi") final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
        return __db.getInvalidationTracker().createLiveData(new String[]{"NEWSARTICLE"}, false, new Callable<SavedArticle>() {
            @Override
            public SavedArticle call() throws Exception {
                @SuppressLint("RestrictedApi") final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
                try {
                    @SuppressLint("RestrictedApi") final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                    @SuppressLint("RestrictedApi") final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
                    @SuppressLint("RestrictedApi") final int _cursorIndexOfPublishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "publishedAt");
                    @SuppressLint("RestrictedApi") final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
                    @SuppressLint("RestrictedApi") final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
                    @SuppressLint("RestrictedApi") final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
                    @SuppressLint("RestrictedApi") final int _cursorIndexOfUrlToImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlToImage");
                    final SavedArticle _result;
                    if(_cursor.moveToFirst()) {
                        final int _tmpId;
                        _tmpId = _cursor.getInt(_cursorIndexOfId);
                        final String _tmpDescription;
                        if (_cursor.isNull(_cursorIndexOfDescription)) {
                            _tmpDescription = null;
                        } else {
                            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
                        }
                        final String _tmpPublishedAt;
                        if (_cursor.isNull(_cursorIndexOfPublishedAt)) {
                            _tmpPublishedAt = null;
                        } else {
                            _tmpPublishedAt = _cursor.getString(_cursorIndexOfPublishedAt);
                        }
                        final Source _tmpSource;
                        final String _tmp;
                        if (_cursor.isNull(_cursorIndexOfSource)) {
                            _tmp = null;
                        } else {
                            _tmp = _cursor.getString(_cursorIndexOfSource);
                        }
                        _tmpSource = __classConvertors.toSource(_tmp);
                        final String _tmpTitle;
                        if (_cursor.isNull(_cursorIndexOfTitle)) {
                            _tmpTitle = null;
                        } else {
                            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
                        }
                        final String _tmpUrl;
                        if (_cursor.isNull(_cursorIndexOfUrl)) {
                            _tmpUrl = null;
                        } else {
                            _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
                        }
                        final String _tmpUrlToImage;
                        if (_cursor.isNull(_cursorIndexOfUrlToImage)) {
                            _tmpUrlToImage = null;
                        } else {
                            _tmpUrlToImage = _cursor.getString(_cursorIndexOfUrlToImage);
                        }
                        _result = new SavedArticle(_tmpId,_tmpDescription,_tmpPublishedAt,_tmpSource,_tmpTitle,_tmpUrl,_tmpUrlToImage);
                    } else {
                        _result = null;
                    }
                    return _result;
                } finally {
                    _cursor.close();
                }
            }

            @SuppressLint("RestrictedApi")
            @Override
            protected void finalize() {
                _statement.release();
            }
        });
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
