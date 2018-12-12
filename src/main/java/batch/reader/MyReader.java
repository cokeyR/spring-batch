package batch.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import batch.mapper.PersonEntity;

public class MyReader implements ItemReader<PersonEntity>{
	private File file;
	private BufferedReader reader;

	public MyReader() throws UnsupportedEncodingException, FileNotFoundException {
		file=new File("data.txt");
		
		reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));

	}
	@Override
	public PersonEntity read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		String line=reader.readLine();
		if(line==null||line.equals(""))
			return null;
		String [] metas=line.split("\\|");
		PersonEntity entity=new PersonEntity();
		entity.setNumber(metas[0]);
		entity.setName(metas[1]);
		entity.setIdNum(metas[4]);
		return entity;
	}
}

