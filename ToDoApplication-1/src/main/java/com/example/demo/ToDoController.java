package com.example.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Dao.Dao;
//import com.example.demo.Dao.UserRepository;
import com.example.demo.model.User;


@Controller
public class ToDoController {

//@Autowired
//private UserRepository ur;
@Autowired
private Dao dao;

@RequestMapping(value="/Mona")
@ResponseBody
public String bandaMona1() {
System.out.println("MOna");
	return "Hai Mona";
}
//html form for adding values
@RequestMapping(value="/")
public ModelAndView insert() {
	return new ModelAndView("index", "user", new User());
}
//html form for id
@RequestMapping(value="/id")
public String id() {
	
	return "pg";
}

//Displaying using Post
@RequestMapping(value="/details", method=RequestMethod.POST)
public ModelAndView saveAndDisplay(@ModelAttribute("user") User user) {
//    H2 console
//    ur.save(user);
//    ModelAndView mv = new ModelAndView("display");
//	List<User> s= (List<User>) ur.findAll();
//	mv.addObject("s", s);
	User s = null; 
	dao.registerUser(user);
	List<User> s1 = dao.displayAllUser();
	 ModelAndView mv = new ModelAndView("display");
	 mv.addObject("s", s1);
	return mv;

}
//displaying all
@RequestMapping(value="/displayAll")
public ModelAndView displayAll() {
	List<User> s1 = dao.displayAllUser();
	 ModelAndView mv = new ModelAndView("display");
	 mv.addObject("s", s1);
	return mv;

}
//displaying by id
@RequestMapping(value="/user1")
public ModelAndView displayById(@RequestParam("uid") String uid) {
	ModelAndView mv2;
	int id1 = Integer.parseInt(uid);
	System.out.println("id is"+ id1);
    User user =dao.searchById(id1);
    if(user==null) {
        System.out.println("Id does not existe");
        mv2 = new ModelAndView("Error");
    }
    else {
    System.out.println("ddddddddddddddddddddddddddddddisplayyyyyyyyyyy");
	mv2 = new ModelAndView("displayById");
	mv2.addObject("fname", user.getUfname());
	mv2.addObject("lname", user.getUlname());
	mv2.addObject("age", user.getUage());
	mv2.addObject("email", user.getUemail());
	mv2.addObject("password", user.getUpassword());
	mv2.addObject("phoneNumber", user.getUphoneNumber());
    }
    return mv2;
}

  //Delete by id and retrieve
    @RequestMapping(value="/user3")
    public ModelAndView deleteById(@RequestParam("uid") String uid) {
    	   ModelAndView mv3;
    	int id1 = Integer.parseInt(uid);
//        User user =dao.searchById(id1);
//        System.out.println("fghjkml,");
           int i = dao.deleteById(id1);
           if(i >0) {
        	 mv3= new ModelAndView("Success");	   
            }
           else {
        	 mv3 = new ModelAndView("Error");
           }
    	return mv3;
        
}
////Update by id and retrieve
//@RequestMapping(value="/user2")
//public ModelAndView updateById(@RequestParam("uid") String uid) {
//	int id1 = Integer.parseInt(uid);
//    Optional<User> userop =ur.findById(id1);
//    if(!userop.isPresent()) {
//    return null;
//    }
//    else {
//    User user=userop.get();  
//    System.out.println("g");
//	return new ModelAndView("searchById", "user", user);
//    }
//    }
////Updating values
//@RequestMapping(value="/detail")
//public ModelAndView updateAndDisplay(@ModelAttribute("user") User user) {
//    ur.save(user);
//	ModelAndView mv1 = new ModelAndView("displayById");
//	mv1.addObject("fname", user.getUfname());
//	mv1.addObject("lname", user.getUlname());
//	mv1.addObject("age", user.getUage());
//	mv1.addObject("email", user.getUemail());
//	mv1.addObject("password", user.getUpassword());
//	mv1.addObject("phoneNumber", user.getUphoneNumber());
//	return mv1;
//}
//Update by id and retrieve
@RequestMapping(value="/user2")
public ModelAndView updatedById(@RequestParam("uid") String uid) {
	int id1 = Integer.parseInt(uid);
	 ModelAndView mv2 ;
	System.out.println("id is"+ id1);
    User user1 =dao.searchById(id1);
    if(user1==null) {
        System.out.println("Id does not existe");
       mv2 = new ModelAndView("Error");
    }
    else {
    User user=user1;  
	mv2= new ModelAndView("searchById", "user", user);
    }
    return mv2;
    }
//Updating values
@RequestMapping(value="/detail")
public ModelAndView updateAndDisplay(@ModelAttribute("user") User user) {
	   ModelAndView mv3;
//	int id1 = Integer.parseInt(uid);
// User user =dao.searchById(id1);
    int i = dao.updateById(user);
    if(i >0) {
 	 mv3= new ModelAndView("Success");	   
     }
    else {
 	 mv3 = new ModelAndView("Error");
    }
	return mv3;
}
}
