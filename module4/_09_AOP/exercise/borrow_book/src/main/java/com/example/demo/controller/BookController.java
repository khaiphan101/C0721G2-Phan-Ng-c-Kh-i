package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.BorrowBook;
import com.example.demo.service.BookService;
import com.example.demo.service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    BorrowBookService borrowBookService;


    @GetMapping("")
    public String displayBlog(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("bookList", bookService.findAll(pageable));
        return "list";
    }

    @GetMapping("/borrow-book/{id}")
    public ModelAndView borrowForm(@PathVariable int id) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("borrow");
            modelAndView.addObject("book", book.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/borrow-book")
    public String borrowBook(@ModelAttribute("book") Book book,Model model, @PageableDefault(size = 5) Pageable pageable, RedirectAttributes redirectAttributes) {
        if (!book.getAmount().equals("0")) {
            book.setAmount(String.valueOf(Integer.parseInt(book.getAmount())-1));
            bookService.save(book);

            BorrowBook borrowBook = new BorrowBook();
            borrowBook.setBook(book);
            borrowBookService.save(borrowBook);


            model.addAttribute("bookList", bookService.findAll(pageable));
//        modelAndView.addObject("message", "Borrow Book  successfully");

            redirectAttributes.addFlashAttribute("message",
                    "Borrow Book  successfully");
            return "redirect:";
        } else {
            return "/error.404";
        }
    }

    @GetMapping("/borrow-list")
    public String displayBorrowList(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("borrowList", borrowBookService.findAll(pageable));
        return "borrowList";
    }

    @GetMapping("/return-book/{id}")
    public String returnBook(@PathVariable int id,Model model, @PageableDefault(size = 5) Pageable pageable, RedirectAttributes redirectAttributes) {

        Optional<BorrowBook> borrowBook = borrowBookService.findById(id);
        Book book = borrowBook.get().getBook();
        book.setAmount(String.valueOf(Integer.parseInt(book.getAmount())+1));
        bookService.save(book);

        borrowBookService.remove(borrowBook.get().getId());
        model.addAttribute("borrowList", borrowBookService.findAll(pageable));
//        modelAndView.addObject("message", "Borrow Book  successfully");

        redirectAttributes.addFlashAttribute("message",
                "Return Book  successfully");
        return "redirect:/borrow-list";
    }
}
