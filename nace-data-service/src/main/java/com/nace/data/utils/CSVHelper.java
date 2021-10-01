package com.nace.data.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.nace.data.bean.NaceBean;

public class CSVHelper {
	
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "orderid", "level", "code", "description", 
			  "itemincludes", "extraitemincludes",  "rulings", "itemexcludes", "referenceid"};

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<NaceBean> csvToBean(InputStream is) {
		List<NaceBean> data = new ArrayList<NaceBean>();
		try {

			BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			CSVParser csvParser = new CSVParser(fileReader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				NaceBean dt = new NaceBean(Long.parseLong(csvRecord.get("orderid")),
						Integer.parseInt(csvRecord.get("level")), csvRecord.get("code"), csvRecord.get("parent"),
						csvRecord.get("description"), csvRecord.get("itemincludes"), csvRecord.get("extraitemincludes"),
						csvRecord.get("rulings"), csvRecord.get("itemexcludes"),
						csvRecord.get("referenceid"));

				data.add(dt);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
		return data;
	}
}
