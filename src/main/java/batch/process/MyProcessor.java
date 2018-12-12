package batch.process;

import org.springframework.batch.item.ItemProcessor;

import batch.mapper.PersonEntity;

public class MyProcessor implements ItemProcessor<PersonEntity, PersonEntity>{

	@Override
	public PersonEntity process(PersonEntity item) throws Exception {
		String idnum=item.getIdNum();
		if(idnum.endsWith("6"))
			return item;
		return null;
	}

}
