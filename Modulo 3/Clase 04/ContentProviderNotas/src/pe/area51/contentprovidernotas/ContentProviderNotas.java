package pe.area51.contentprovidernotas;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class ContentProviderNotas extends ContentProvider {

	private static final String URI_STRING = "content://pe.area51.contentprovidernotas/notas";
	private static final Uri URI = Uri.parse(URI_STRING);

	private static final String AUTHORITY = "pe.area51.contentprovidernotas";

	private DatabaseManager databaseManager;
	private static final String DATABASE_TABLE_NOTAS = DatabaseManager.TABLE_NOTAS;

	private static final int NOTAS = 1;
	private static final int NOTAS_ID = 2;
	private static final UriMatcher URI_MATCHER;

	private static final String MIME_DIR = "vnd.android.cursor.dir/vnd.pe.area51.notas";
	private static final String MIME_ITEM = "vnd.android.cursor.item/vnd.pe.area51.notas";

	static {
		URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
		URI_MATCHER.addURI(AUTHORITY, "notas", NOTAS);
		URI_MATCHER.addURI(AUTHORITY, "notas/#", NOTAS_ID);
	}

	@Override
	public boolean onCreate() {
		databaseManager = new DatabaseManager(getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		if (URI_MATCHER.match(uri) == NOTAS_ID) {
			selection = "_id=" + uri.getLastPathSegment();
		}
		return databaseManager.getReadableDatabase().query(
				DATABASE_TABLE_NOTAS, projection, selection, selectionArgs,
				null, null, sortOrder);
	}

	@Override
	public String getType(Uri uri) {
		switch (URI_MATCHER.match(uri)) {
		case NOTAS:
			return MIME_DIR;
		case NOTAS_ID:
			return MIME_ITEM;
		default:
			return null;
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		long id = databaseManager.getWritableDatabase().insert(
				DATABASE_TABLE_NOTAS, null, values);
		return ContentUris.withAppendedId(URI, id);
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		if (URI_MATCHER.match(uri) == NOTAS_ID) {
			selection = "_id=" + uri.getLastPathSegment();
		}
		return databaseManager.getWritableDatabase().delete(
				DATABASE_TABLE_NOTAS, selection, selectionArgs);
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		if (URI_MATCHER.match(uri) == NOTAS_ID) {
			selection = "_id=" + uri.getLastPathSegment();
		}
		return databaseManager.getWritableDatabase().update(
				DATABASE_TABLE_NOTAS, values, selection, selectionArgs);
	}

}
