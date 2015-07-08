package old;

import java.io.*;

/** Interfaca Serializer - potrzebny do wykonania serializacji
 * @author Boles³aw Denk
 * @version 0.1
 */ 

public interface Serializer 
{
	/** Metoda interfacu wykonuj¹ca serializacjê obiektu do tablicy bajtów */
    byte[] serializuj() throws IOException;

    /** Metoda interfacu dokonuj¹ca deserializacjê na podstawie tablicy bajtów */
    void deserializuj( byte[] dane ) throws IOException;	
}
