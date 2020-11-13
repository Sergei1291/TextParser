package com.epam.textparser.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileDataReader implements DataReader {

    public String read(String fileName) throws DataException {

        try {

            Path path = Paths.get(fileName);

            List<String> lines = Files.readAllLines(path);

            StringBuilder data = new StringBuilder();

            lines.forEach(data::append);

            return new String(data);

        } catch (IOException e) {
            throw new DataException(e);
        }

    }

}