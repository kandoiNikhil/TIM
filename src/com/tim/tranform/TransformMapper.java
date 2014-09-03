package com.tim.tranform;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TransformMapper extends
		Mapper<IntWritable, Text, Text, Text> {
	@Override
	public void map(IntWritable key, Text value, Context context) {
		String line = value.toString();
		String[] fields = line.split(",");		
	}
}