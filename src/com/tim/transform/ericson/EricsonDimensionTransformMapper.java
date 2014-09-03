package com.tim.transform.ericson;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EricsonDimensionTransformMapper extends
		Mapper<IntWritable, Text, ImmutableBytesWritable, Put> {
	@Override
	public void map(IntWritable key, Text value, Context context) {
		String line = value.toString();
		String[] fields = line.split(",");
		try {
			int test = Integer.parseInt(fields[0]);
		} catch (NumberFormatException e) {
			e.printStackTrace(System.err);
		}

	}
}
