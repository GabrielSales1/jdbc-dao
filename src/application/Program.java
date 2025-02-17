package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
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
		
		System.out.println("\n/// TEST 4: Seller Insert ===== ");
		Seller newSeller = new Seller(null,"Greg","greg@gmail.com",new Date(),3000.00,department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n/// TEST 5: Seller UPDATE ===== ");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n/// TEST 6: Seller DELETE ===== ");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deletion success");
		
		sc.close();

	}
}
