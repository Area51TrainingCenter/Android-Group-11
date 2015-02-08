package pe.area51.ejemploparcel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

public class ParcelTest implements Parcelable {

	private String stringTest;
	private boolean booleanTest;
	private int intTest;
	private int[] intArrayTest;
	private List<String> stringListTest;
	// Utilizaremos un objeto Location para demostrar cómo poner un objeto
	// parcelable dentro de otro (El objeto Location implementa la interfaz
	// Parcelable).
	private Location locationTest;

	public ParcelTest() {
		stringTest = "";
		intArrayTest = new int[1];
		stringListTest = new ArrayList<String>();
		locationTest = new Location("");
	}

	public ParcelTest(Parcel parcel) {
		this();
		readFromParcel(parcel);
	}

	// Este método debe devolver "0" o "1" (constante
	// "Parcelable.CONTENTS_FILE_DESCRIPTOR"). Se nameutiliza la constante
	// "CONTENTS_FILE_DESCRIPTOR" (o 1), cuando se implementa la interfaz
	// "Parcelable" con la clase "FileDescriptor". En todos los otros casos,
	// debe devolverse 0.
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(stringTest);
		// No hay un método directo para escribir un booleano, por lo que
		// utilizaré un byte (aunque si ven la implementación, el framework
		// vuelve a convertirlo a entero).
		dest.writeByte((byte) (booleanTest ? 1 : 0));
		dest.writeInt(intTest);
		dest.writeIntArray(intArrayTest);
		dest.writeList(stringListTest);
		dest.writeParcelable(locationTest, flags);
	}

	// El parcel debe leerse en el mismo orden en que se escribió.
	private void readFromParcel(Parcel source) {
		stringTest = source.readString();
		booleanTest = source.readByte() == 1 ? true : false;
		intTest = source.readInt();
		// Utilizaremos el método "readIntArray()" cuando sepamos de antemano el
		// tamaño del arreglo (ya que escribirá los valores en el arreglo que se
		// ponga como parámetro de entrada y este debe ser del tamaño exacto).
		// Como este no es el caso, utilizaremos el método "createIntArray()".
		intArrayTest = source.createIntArray();
		source.readList(stringListTest, List.class.getClassLoader());
		locationTest = source.readParcelable(Location.class.getClassLoader());
	}

	// El objeto "Creator" es necesario para recrear nuestro objeto "ParcelTest"
	// a partir de un "Parcel". Debe crearse como público y estático.
	public static final Parcelable.Creator<ParcelTest> CREATOR = new Parcelable.Creator<ParcelTest>() {

		@Override
		public ParcelTest createFromParcel(Parcel source) {
			return new ParcelTest(source);
		}

		@Override
		public ParcelTest[] newArray(int size) {
			return new ParcelTest[size];
		}
	};

	// Sobrescribimos el método "toString()" de la clase "Object" (recordar que
	// toda clase en Java hereda de "Object") para mostrar fácilmente los
	// valores del objeto en un campo de texto. No es necesario sobrescribir
	// este método para crear un objeto "Parcelable".
	@Override
	public String toString() {
		try {
			JSONArray intArrayTestJsonArray = new JSONArray();
			for (int i = 0; i < intArrayTest.length; i++) {
				intArrayTestJsonArray.put(intArrayTest[i]);
			}
			JSONArray stringListTestJsonArray = new JSONArray();
			Iterator<String> iterator = stringListTest.iterator();
			while (iterator.hasNext()) {
				stringListTestJsonArray.put(iterator.next());
			}
			JSONObject parcelTestJsonObject = new JSONObject();
			parcelTestJsonObject.put("stringTest", stringTest);
			parcelTestJsonObject.put("booleanTest", booleanTest);
			parcelTestJsonObject.put("intTest", intTest);
			parcelTestJsonObject.put("intArrayTest", intArrayTestJsonArray);
			parcelTestJsonObject.put("stringListTest", stringListTestJsonArray);
			parcelTestJsonObject.put("locationTest", locationTest.toString());
			return parcelTestJsonObject.toString();
		} catch (JSONException e) {
			e.printStackTrace();
			return "";
		}
	}

	// Utilizaremos el estilo "Fluent Interface" para los métodos accesores:
	// http://en.wikipedia.org/wiki/Fluent_interface

	public String getStringTest() {
		return stringTest;
	}

	public ParcelTest setStringTest(String stringTest) {
		this.stringTest = stringTest;
		return this;
	}

	public boolean isBooleanTest() {
		return booleanTest;
	}

	public ParcelTest setBooleanTest(boolean booleanTest) {
		this.booleanTest = booleanTest;
		return this;
	}

	public int getIntTest() {
		return intTest;
	}

	public ParcelTest setIntTest(int intTest) {
		this.intTest = intTest;
		return this;
	}

	public int[] getIntArrayTest() {
		return intArrayTest;
	}

	public ParcelTest setIntArrayTest(int[] intArrayTest) {
		this.intArrayTest = intArrayTest;
		return this;
	}

	public List<String> getStringListTest() {
		return stringListTest;
	}

	public ParcelTest setStringListTest(List<String> stringListTest) {
		this.stringListTest = stringListTest;
		return this;
	}

	public Location getLocationTest() {
		return locationTest;
	}

	public ParcelTest setLocationTest(Location locationTest) {
		this.locationTest = locationTest;
		return this;
	}

}
