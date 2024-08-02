package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("/// TEST 1: Seller find by ID ===== ");
		Seller seller = sellerDao.findById(1);
		System.out.println(seller);
		
		System.out.println("\n/// TEST 2: Seller find by Department ===== ");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findDepartment(department);
		for (Seller sellers : list) {
			System.out.println(sellers);
		}
		
		System.out.println("\n/// TEST 3: Seller find ALL ===== ");
		list = sellerDao.findAll();
		for (Seller sellers : list) {
			System.out.println(sellers);
		}
	}
}
