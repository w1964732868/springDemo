package com.wu.controller;

import com.wu.pojo.Books;
import com.wu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Controller
@RequestMapping("/book")
public class BookController {
    //controller调service
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> books = bookService.queryAllBook();
        model.addAttribute("list", books);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddPaper")
    public String toAddPaper(Model model) {
        List<Books> books = bookService.queryAllBook();
        model.addAttribute("list", books);
        return "addBook";
    }

    //新增书籍
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        bookService.addBook(books);
        return "redirect:/book/allBook";//重定向
    }

    //跳转到修改书籍页面
    @RequestMapping("/toUpdatePaper")
    public String toUpdatePaper(int id,Model model) {
        Books books = bookService.queryBook(id);
        model.addAttribute("Qbooks",books);
        return "updateBook";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        bookService.updateBook(books);
        return "redirect:/book/allBook";//重定向
    }

    //删除书籍
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBook(id);
        return "redirect:/book/allBook";//重定向
    }


}
