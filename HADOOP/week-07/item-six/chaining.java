import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.*;
import org.apache.hadoop.conf.Configured;

public class chaining extends Configured implements Tool {

 private static final String OUTPUT_PATH = "intermediate_output";

 @Override
 public int run(String[] args) throws Exception {
  
Configuration conf = getConf();
  Job job = new Job(conf, "Job1");
  job.setJarByClass(chaining.class);

  job.setMapperClass(MaxTemperatureMapper.class);
  job.setReducerClass(MaxTemperatureReducer.class);

  job.setOutputKeyClass(Text.class);
  job.setOutputValueClass(IntWritable.class);

  job.setInputFormatClass(TextInputFormat.class);
  job.setOutputFormatClass(TextOutputFormat.class);

  TextInputFormat.addInputPath(job, new Path(args[0]));
  TextOutputFormat.setOutputPath(job, new Path(OUTPUT_PATH));

  job.waitForCompletion(true); 


  


  Configuration conf2 = getConf();
  Job job2 = new Job(conf2, "Job 2");
  job2.setJarByClass(chaining.class);

  job2.setMapperClass(MaxTemperatureMapper1.class);
  job2.setReducerClass(MaxTemperatureReducer1.class);

  job2.setOutputKeyClass(Text.class);
  job2.setOutputValueClass(Text.class);

  job2.setInputFormatClass(TextInputFormat.class);
  job2.setOutputFormatClass(TextOutputFormat.class);

  TextInputFormat.addInputPath(job2, new Path(OUTPUT_PATH));
  TextOutputFormat.setOutputPath(job2, new Path(args[1]));

  return job2.waitForCompletion(true) ? 0 : 1;
 }

 public static void main(String[] args) throws Exception {
  // TODO Auto-generated method stub
  if (args.length != 2) {
   System.err.println("Enter valid number of arguments <Inputdirectory>  <Outputlocation>");
   System.exit(0);
  }
  ToolRunner.run(new Configuration(), new chaining(), args);
 }
}
