package com.motoz.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.motoz.Dao.CategoryDao;
import com.motoz.Dao.CustomerDao;
import com.motoz.Dao.ProductDao;
import com.motoz.Dao.SupplierDao;
import com.motoz.model.Category;
import com.motoz.model.Customer;
import com.motoz.model.Product;
import com.motoz.model.Supplier;

@Controller
public class HomeController {
	@Autowired
	CustomerDao d;
	@Autowired
	CategoryDao c;
	@Autowired
	SupplierDao s;
	@Autowired
	ProductDao p;

	@RequestMapping(value ={"/Home","/index" })
	String indexPage() {
		return "index";
	}

	@RequestMapping("/aboutus")
	String aboutusPage() {
		return "aboutus";
	}

	@RequestMapping("/login")
	String loginPage() {
		return "login";
	}

	@RequestMapping("/contact")
	String contactPage() {
		return "contact";
	}

	@RequestMapping("/signup")
	String signupPage(Model m) {
		m.addAttribute("Customermodel", new Customer());
		return "signup";
	}

	@RequestMapping("/getuser")
	String getuser(@Valid @ModelAttribute("Customermodel") Customer c, BindingResult b, Model m) {
		if (b.hasErrors()) {
			m.addAttribute("Customermodel", c);
			return "signup";
		} else {
			if (d.insertuser(c)) {
				return "login";
			} else

			{
				m.addAttribute("Customer", c);
				return "signup";
			}
		}
	}

	@RequestMapping("/Category")
	String CategoryPage(Model x) {
		x.addAttribute("category", new Category());
		x.addAttribute("catable", c.showall());
		x.addAttribute("check", true);
		return "Category";
	}

	@RequestMapping("/getcategory")
	String getcategory(@Valid @ModelAttribute("category") Category i, BindingResult br, Model x) {
		if (br.hasErrors()) {
			System.out.println("error because of model");
			System.out.println(br.getAllErrors());
			x.addAttribute("category", c);
			x.addAttribute("catable", c.showall());
			return "Category";
		} else {
			if (c.insertcat(i)) {
				return "redirect:/Category";
			} else {
				System.out.println("error by dao");
				x.addAttribute("category", c);
				x.addAttribute("catable", c.showall());
				return "Category";
			}
		}
	}

	@RequestMapping("/updcat")
	String updcategory(@Valid @ModelAttribute("category") Category i, BindingResult br, Model x) {
		if (br.hasErrors()) {
			System.out.println("error because of model");
			System.out.println(br.getAllErrors());
			x.addAttribute("category", c);
			x.addAttribute("catable", c.showall());
			return "Category";
		} else {
			if (c.updatecat(i)) {
				return "redirect:/Category";
			} else {
				System.out.println("error by dao");
				x.addAttribute("category", c);
				x.addAttribute("catable", c.showall());
				return "Category";
			}
		}
	}

	@RequestMapping("/Supplier")
	String SupplierPage(Model y) {
		System.out.println(s.showall());
		y.addAttribute("supplier", new Supplier());
		y.addAttribute("supply", s.showall());
		y.addAttribute("check", true);
		return "Supplier";
	}

	@RequestMapping("/getsupplier")
	String getsupplier(@Valid @ModelAttribute("supplier") Supplier r, BindingResult br, Model y) {
		if (br.hasErrors()) {
			System.out.println("error because of model");
			System.out.println(br.getAllErrors());
			y.addAttribute("supplier", r);
			y.addAttribute("supply", s.showall());
			return "Supplier";
		} else {
			if (s.insertsup(r)) {
				return "redirect:/Supplier";
			} else {
				System.out.println("error by dao");
				y.addAttribute("supplier", r);
				y.addAttribute("supply", s.showall());
				return "Supplier";
			}
		}
	}

	@RequestMapping("/updsup")
	String updsupplier(@Valid @ModelAttribute("supplier") Supplier r, BindingResult br, Model y) {
		if (br.hasErrors()) {
			System.out.println("error because of model");
			System.out.println(br.getAllErrors());
			y.addAttribute("supplier", r);
			y.addAttribute("supply", s.showall());
			return "Supplier";
		} else {
			if (s.updatesup(r)) {
				return "redirect:/Supplier";
			} else {
				System.out.println("error by dao");
				y.addAttribute("supplier", r);
				y.addAttribute("supply", s.showall());
				return "Supplier";
			}
		}
	}
	@RequestMapping("/Product")
	String ProductPage(Model z) {
		z.addAttribute("product", new Product());
		z.addAttribute("producter", p.showall());
		z.addAttribute("check", true);
		return "Product";
	}

	@RequestMapping("/getproduct")
	String getProduct(@Valid @ModelAttribute("product") Product t, BindingResult br, Model z) throws Exception {
		if (br.hasErrors()) {
			System.out.println("error because of model");
			System.out.println(br.getAllErrors());
			z.addAttribute("product", t);
			z.addAttribute("producter", p.showall());
			return "Product";
		} else {
			if (p.insertprodu(t)) {
				String filePath = "D:\\ecp 1\\motozfrontend\\src\\main\\webapp\\resources\\ProductImage\\";
				filePath = filePath + String.valueOf(t.getId()) + ".jpg";
				File f = new File(filePath);
				MultipartFile imagefile = t.getProdImage();
				if (!f.exists()) {
					byte[] imageBytes = imagefile.getBytes();
					FileOutputStream fileOutputStream = new FileOutputStream(f);
					/***
					 *** BufferedOutputStream bufferedOutputStream = new
					 * BufferedOutputStream(fileOutputStream);
					 ** bufferedOutputStream.write(imageBytes);
					 *** 8bufferedOutputStream.close();
					 ***/
					fileOutputStream.write(imageBytes);
					fileOutputStream.close();
				}
				z.addAttribute("getproduct", t);
				return "redirect:/Product";
			} else {
				System.out.println("error by dao");
				z.addAttribute("product", t);
				z.addAttribute("producter", p.showall());
				return "Product";
			}
		}
	}

	@RequestMapping("/updprodu")
	String updProduct(@Valid @ModelAttribute("product") Product t, BindingResult br, Model z) {
		if (br.hasErrors()) {
			System.out.println("error because of model");
			System.out.println(br.getAllErrors());
			z.addAttribute("product", t);
			z.addAttribute("producter", p.showall());
			return "Product";
		} else {
			if (p.updateprodu(t)) {
				return "redirect:/Product";
			} else {
				System.out.println("error by dao");
				z.addAttribute("product", t);
				z.addAttribute("producter", p.showall());
				return "Product";
			}
		}
	}
	@RequestMapping("/delcat/{cid}")
	String delcat(@PathVariable("cid") int id) {
		c.deletecat(id);
		return "redirect:/Category";
	}

	@RequestMapping("/editcat")
	String editcat(@RequestParam("getcatid") int id, Model x) {
		x.addAttribute("category", c.showone(id));
		x.addAttribute("catable", c.showall());
		x.addAttribute("check", false);
		return "Category";
	}

	@RequestMapping("/delsup/{sid}")
	String delsup(@PathVariable("sid") int id) {
		System.out.println(id);
		s.deletesup(id);
		return "redirect:/Supplier";
	}

	@RequestMapping("/editsup")
	String editsup(@RequestParam("getsupid") int id, Model y) {
		y.addAttribute("supplier", s.showone(id));
		y.addAttribute("Supply", s.showall());
		y.addAttribute("check", false);
		return "Supplier";
	}
	@RequestMapping("/delprodu")
	String delprodu(@RequestParam("pid") int id) {
		p.deleteprodu(id);
		return "redirect:/Product";
	}

	@RequestMapping("/editprodu")
	String editprodu(@RequestParam("getproduid") int id, Model z) {
		z.addAttribute("product", p.showone(id));
		z.addAttribute("producter", p.showall());
		z.addAttribute("check", false);
		return "Product";
	}
	
	@RequestMapping(value = {"/signin"}, method = RequestMethod.GET)
	public String LoginController(@RequestParam("uname") String uname, @RequestParam("psw") String psw) {
		System.out.println(uname);
		System.out.println(psw);
		List<Customer> allUser = d.showall();
		boolean userExist = false;
		for (Customer cus : allUser) {
			if (cus.getEmail().equals(uname) && cus.getUpassword().equals(psw)) {
				userExist = true;
			}
		}
		if (userExist) {
			System.out.println("wellcome" + uname);
			return "index";
		} else {
			return "login";
		}
	}
}
