package com.tim.transform.nokia;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class NokiaDimensionTransformMapper extends
		Mapper<IntWritable, Text, Text, Text> {
	@Override
	protected void map(IntWritable key, Text value, Context context) {
		String line = value.toString();
		String[] tokens = line.split(",");
		
	}

}
