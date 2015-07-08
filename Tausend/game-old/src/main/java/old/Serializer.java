package old;

import java.io.*;

/** Interfaca Serializer - potrzebny do wykonania serializacji
 * @author Boles�aw Denk
 * @version 0.1
 */ 

public interface Serializer 
{
	/** Metoda interfacu wykonuj�ca serializacj� obiektu do tablicy bajt�w */
    byte[] serializuj() throws IOException;

    /** Metoda interfacu dokonuj�ca deserializacj� na podstawie tablicy bajt�w */
    void deserializuj( byte[] dane ) throws IOException;	
}
