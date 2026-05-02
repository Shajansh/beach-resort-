package com.example.luxevista;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ReservationDao_Impl implements ReservationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Reservation> __insertionAdapterOfReservation;

  private final EntityDeletionOrUpdateAdapter<Reservation> __deletionAdapterOfReservation;

  private final EntityDeletionOrUpdateAdapter<Reservation> __updateAdapterOfReservation;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ReservationDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfReservation = new EntityInsertionAdapter<Reservation>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `reservations` (`id`,`serviceType`,`date`,`guestName`,`roomNumber`,`status`,`notes`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Reservation value) {
        stmt.bindLong(1, value.getId());
        if (value.getServiceType() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getServiceType());
        }
        final Long _tmp = DateConverter.toTimestamp(value.getDate());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp);
        }
        if (value.getGuestName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGuestName());
        }
        if (value.getRoomNumber() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRoomNumber());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getStatus());
        }
        if (value.getNotes() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getNotes());
        }
      }
    };
    this.__deletionAdapterOfReservation = new EntityDeletionOrUpdateAdapter<Reservation>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `reservations` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Reservation value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfReservation = new EntityDeletionOrUpdateAdapter<Reservation>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `reservations` SET `id` = ?,`serviceType` = ?,`date` = ?,`guestName` = ?,`roomNumber` = ?,`status` = ?,`notes` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Reservation value) {
        stmt.bindLong(1, value.getId());
        if (value.getServiceType() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getServiceType());
        }
        final Long _tmp = DateConverter.toTimestamp(value.getDate());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp);
        }
        if (value.getGuestName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGuestName());
        }
        if (value.getRoomNumber() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRoomNumber());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getStatus());
        }
        if (value.getNotes() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getNotes());
        }
        stmt.bindLong(8, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM reservations";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Reservation reservation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfReservation.insert(reservation);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Reservation reservation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfReservation.handle(reservation);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Reservation reservation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfReservation.handle(reservation);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<Reservation> getAll() {
    final String _sql = "SELECT * FROM reservations ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfServiceType = CursorUtil.getColumnIndexOrThrow(_cursor, "serviceType");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfGuestName = CursorUtil.getColumnIndexOrThrow(_cursor, "guestName");
      final int _cursorIndexOfRoomNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "roomNumber");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
      final List<Reservation> _result = new ArrayList<Reservation>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Reservation _item;
        final String _tmpServiceType;
        if (_cursor.isNull(_cursorIndexOfServiceType)) {
          _tmpServiceType = null;
        } else {
          _tmpServiceType = _cursor.getString(_cursorIndexOfServiceType);
        }
        final Date _tmpDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDate);
        }
        _tmpDate = DateConverter.toDate(_tmp);
        final String _tmpGuestName;
        if (_cursor.isNull(_cursorIndexOfGuestName)) {
          _tmpGuestName = null;
        } else {
          _tmpGuestName = _cursor.getString(_cursorIndexOfGuestName);
        }
        final String _tmpRoomNumber;
        if (_cursor.isNull(_cursorIndexOfRoomNumber)) {
          _tmpRoomNumber = null;
        } else {
          _tmpRoomNumber = _cursor.getString(_cursorIndexOfRoomNumber);
        }
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        final String _tmpNotes;
        if (_cursor.isNull(_cursorIndexOfNotes)) {
          _tmpNotes = null;
        } else {
          _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
        }
        _item = new Reservation(_tmpServiceType,_tmpDate,_tmpGuestName,_tmpRoomNumber,_tmpStatus,_tmpNotes);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<Reservation>> getAllLive() {
    final String _sql = "SELECT * FROM reservations ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"reservations"}, false, new Callable<List<Reservation>>() {
      @Override
      public List<Reservation> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfServiceType = CursorUtil.getColumnIndexOrThrow(_cursor, "serviceType");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfGuestName = CursorUtil.getColumnIndexOrThrow(_cursor, "guestName");
          final int _cursorIndexOfRoomNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "roomNumber");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final List<Reservation> _result = new ArrayList<Reservation>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Reservation _item;
            final String _tmpServiceType;
            if (_cursor.isNull(_cursorIndexOfServiceType)) {
              _tmpServiceType = null;
            } else {
              _tmpServiceType = _cursor.getString(_cursorIndexOfServiceType);
            }
            final Date _tmpDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = DateConverter.toDate(_tmp);
            final String _tmpGuestName;
            if (_cursor.isNull(_cursorIndexOfGuestName)) {
              _tmpGuestName = null;
            } else {
              _tmpGuestName = _cursor.getString(_cursorIndexOfGuestName);
            }
            final String _tmpRoomNumber;
            if (_cursor.isNull(_cursorIndexOfRoomNumber)) {
              _tmpRoomNumber = null;
            } else {
              _tmpRoomNumber = _cursor.getString(_cursorIndexOfRoomNumber);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _item = new Reservation(_tmpServiceType,_tmpDate,_tmpGuestName,_tmpRoomNumber,_tmpStatus,_tmpNotes);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
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
  public List<Reservation> getByStatus(final String status) {
    final String _sql = "SELECT * FROM reservations WHERE status = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfServiceType = CursorUtil.getColumnIndexOrThrow(_cursor, "serviceType");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfGuestName = CursorUtil.getColumnIndexOrThrow(_cursor, "guestName");
      final int _cursorIndexOfRoomNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "roomNumber");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
      final List<Reservation> _result = new ArrayList<Reservation>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Reservation _item;
        final String _tmpServiceType;
        if (_cursor.isNull(_cursorIndexOfServiceType)) {
          _tmpServiceType = null;
        } else {
          _tmpServiceType = _cursor.getString(_cursorIndexOfServiceType);
        }
        final Date _tmpDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDate);
        }
        _tmpDate = DateConverter.toDate(_tmp);
        final String _tmpGuestName;
        if (_cursor.isNull(_cursorIndexOfGuestName)) {
          _tmpGuestName = null;
        } else {
          _tmpGuestName = _cursor.getString(_cursorIndexOfGuestName);
        }
        final String _tmpRoomNumber;
        if (_cursor.isNull(_cursorIndexOfRoomNumber)) {
          _tmpRoomNumber = null;
        } else {
          _tmpRoomNumber = _cursor.getString(_cursorIndexOfRoomNumber);
        }
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        final String _tmpNotes;
        if (_cursor.isNull(_cursorIndexOfNotes)) {
          _tmpNotes = null;
        } else {
          _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
        }
        _item = new Reservation(_tmpServiceType,_tmpDate,_tmpGuestName,_tmpRoomNumber,_tmpStatus,_tmpNotes);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
