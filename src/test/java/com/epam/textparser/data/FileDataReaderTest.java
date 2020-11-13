package com.epam.textparser.data;

import org.junit.Assert;
import org.junit.Test;

public class FileDataReaderTest {

    private final static String FILE_NAME = "src/test/resources/dataFileDataReaderTest.txt";
    private final static String FILE_NOT_EXIST = "doesNotExist.txt";

    private final DataReader dataReader = new FileDataReader();

    @Test
    public void testReadShouldReadFile() throws DataException {
        //when
        String actual = dataReader.read(FILE_NAME);
        //then
        Assert.assertEquals("1st sentence. 2nd sentence line  3rd line", actual);
    }

    @Test(expected = DataException.class)//then
    public void testReadShouldThrowDataExceptionWhenFileNotExist() throws DataException {
        //when
        dataReader.read(FILE_NOT_EXIST);
    }

}