package com.epam.textparser.data;

public interface DataReader {

    String read(String fileName) throws DataException;

}