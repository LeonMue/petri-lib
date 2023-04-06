package org.dhbw.ka.ml.petrilib.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class ReadTrackingDataInputTest {

    @Test
    void callingReadByte_should_trackOneByteWasRead() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        byte b = 1;
        out.write(new byte[] {b});
        ReadTrackingDataInput rtin = new ReadTrackingDataInput(new DataInputStream(new ByteArrayInputStream(out.toByteArray())));
        rtin.readByte();
        Assertions.assertEquals(1, rtin.getBytesWasRead());
    }

    @Test
    void callingReadFloat_should_track4BytesWasRead() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        out.writeFloat(0.5f);
        ReadTrackingDataInput rtin = new ReadTrackingDataInput(new DataInputStream(new ByteArrayInputStream(baos.toByteArray())));
        rtin.readFloat();
        Assertions.assertEquals(4, rtin.getBytesWasRead());
    }

    @Test
    void callingSkip10Bytes_should_track10BytesWasRead() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = new byte[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        baos.write(bytes);
        ReadTrackingDataInput rtin = new ReadTrackingDataInput(new DataInputStream(new ByteArrayInputStream(baos.toByteArray())));
        rtin.skipBytes(10);
        Assertions.assertEquals(10, rtin.getBytesWasRead());
    }

}
