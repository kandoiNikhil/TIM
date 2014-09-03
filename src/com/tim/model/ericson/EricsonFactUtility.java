package com.tim.model.ericson;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class EricsonFactUtility {

	static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

	public static Date rule2() {
		return new Date();
	}

	public static Put getPut(String rkey, String family, EricsonFact ed)
			throws IllegalArgumentException, IllegalAccessException {
		byte[] rkey_ = Bytes.toBytes(rkey);
		byte[] family_ = Bytes.toBytes(family);
		Put put = new Put(rkey_);

		for (Field field : ed.getClass().getFields()) {
			if (field.getName().equalsIgnoreCase("DAT_INSERCAO_DW")) {
				String date_ = format.format(((Date) field.get(ed)));
				put.add(family_, Bytes.toBytes(field.getName()),
						Bytes.toBytes(date_));
			} else if (field.getName().equalsIgnoreCase(
					"SKY_ACOMP_TERMINAIS_TAC")) {
				String value = "" + field.getInt(ed);
				put.add(family_, Bytes.toBytes(field.getName()),
						Bytes.toBytes(value));
			} else if (field.getName().equalsIgnoreCase("SKY_DIM_TEMPO")) {
				String value = "" + field.getInt(ed);
				put.add(family_, Bytes.toBytes(field.getName()),
						Bytes.toBytes(value));
			} else
				put.add(family_, Bytes.toBytes(field.getName()),
						Bytes.toBytes((String) field.get(ed)));
		}
		return put;

	}
}
