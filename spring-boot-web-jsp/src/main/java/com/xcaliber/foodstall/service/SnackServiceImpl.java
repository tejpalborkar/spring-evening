package com.xcaliber.foodstall.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xcaliber.foodstall.dao.SnackDao;
import com.xcaliber.foodstall.dto.AllFoodDto;
import com.xcaliber.foodstall.model.Snack;

@Service
@Transactional
public class SnackServiceImpl implements SnackService {

	@Autowired
	SnackDao snackDao;

	@Override
	public String addSanckInfo(AllFoodDto allFoodDto) {
		Snack snack = new Snack();
		snack.setPasta(allFoodDto.getPasta());
		snack.setPoha(allFoodDto.getPoha());

		snackDao.save(snack);
		return null;
	}

	@Override
	public void createSnack(AllFoodDto allFoodDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Snack> getAllSnack() {
		// TODO Auto-generated method stub
		return snackDao.findAll();
	}

	@Override
	public Snack findById(int id) {
		// TODO Auto-generated method stub
		return snackDao.findOne(id);
	}

	@Override
	public void update(Snack sanck, int id) {
		// TODO Auto-generated method stub
		snackDao.saveOrUpdate(sanck);
	}

	@Override
	public void deleteSanckById(int id) {
		// TODO Auto-generated method stub
		snackDao.delete(findById(id));
	}

}
