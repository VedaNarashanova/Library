import './App.css';
import React, {Component} from "react";
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';

import Authors from "../Authors/AuthorList/authors";
import Books from "../Books/BookList/books";
import Countries from "../Countries/CountryList/countries";
import LibraryService from "../../repository/libraryRepository";
import BookAdd from "../Books/BookAdd/bookAdd";
import Categories from "../Categories/categories";
import BookEdit from "../Books/BookEdit/bookEdit";
import Header from "../Header/header";
import AuthorAdd from "../Authors/AuthorAdd/authorAdd";
import CountryAdd from "../Countries/CountryAdd/countryAdd";


//klasna komponenta mora da ima konstruktor,rende metod i didMount
class App extends Component{

    constructor(props) {
        super(props);
        this.state={
            authors:[],
            books:[],
            countries:[],
            categories:[],//niza
            selectedBook:{}//objekt
        }
    }

    render(){
        return(
            // <div>
            //     <Books books={this.state.books}/>
            // </div>
            <Router>
                <Header/>
                <main>
                    <div className="container">
                        <Routes>
                            <Route path={"/add-author"} element={<AuthorAdd countries={this.state.countries} onAddAuthor={this.addAuthor}/>} />
                            <Route path={"/authors"} element={<Authors authors={this.state.authors} onDelete={this.deleteAuthor}/>} />

                            <Route path={"/add-country"} element={<CountryAdd onAddCountry={this.addCountry}/>} />
                            <Route path={"/countries"} element={<Countries countries={this.state.countries} />} />

                            <Route path={"/add-book"} element={<BookAdd authors={this.state.authors} categories={this.state.categories} onAddBook={this.addBook}/>} />
                            <Route path={"/books/categories"} element={<Categories  categories={this.state.categories} />} />
                            <Route path={"/edit-book/:id"} element={<BookEdit authors={this.state.authors} categories={this.state.categories} onEditBook={this.editBook} book={this.state.selectedBook}/>} />

                            <Route path={"/books"} element={<Books books={this.state.books} onDelete={this.deleteBook} onEdit={this.getBook} onRent={this.rentBook} onFilter={this.filterByAuthor}/>}/>

                            <Route path={"/"} element={<Books books={this.state.books}/>} />
                        </Routes>
                        </div>
                </main>
            </Router>

        );
    }


    componentDidMount(){
        this.loadAuthors();
        this.loadBooks();
        this.loadCountries();
        this.loadCategories();
    }


    loadAuthors=()=>{
        LibraryService.fetchAuthors()
            .then((data)=>{
                this.setState({
                    authors: data.data
                })
            })
    }

    loadCategories = () => {
        LibraryService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }

    loadBooks=()=>{
        LibraryService.fetchBooks()
            .then((data)=>{
                this.setState({
                    books: data.data
                })
            })
    }

    loadCountries=()=>{
        LibraryService.fetchCountries()
            .then((data)=>{
                this.setState({
                    countries: data.data
                })
            })
    }

    deleteBook=(id)=>{
        LibraryService.deleteBook(id)
            .then(()=>{
                this.loadBooks();
        })
    }
    rentBook=(id)=>{
        LibraryService.rentBook(id)
            .then(()=>{
                this.loadBooks();
            });
    }

    addBook=(name,category,author,availableCopies) => {
        LibraryService.addBook(name,category,author.id,availableCopies)
            .then(()=>{
                this.loadBooks()
            });
    }

    editBook=(id,name,category,author,availableCopies) =>{
        LibraryService.editBook(id,name,category,author,availableCopies)
            .then(()=>{
                this.loadBooks()
            })
    }

    getBook=(id)=>{
        LibraryService.getBook(id)
            .then((data)=>{
                this.setState({
                    selectedBook:data.data
                })
            })
    }

    addAuthor=(name,surname,country) => {
        LibraryService.addAuthor(name,surname,country.id)
            .then(()=>{
                this.loadAuthors()
            });
    }
    deleteAuthor=(id)=>{
        LibraryService.deleteAuthor(id)
            .then(()=>{
                this.loadAuthors();
            })
    }

    addCountry=(name,continent) => {
        LibraryService.addCountry(name,continent)
            .then(()=>{
                this.loadCountries()
            });
    }

    filterByAuthor=()=>{
        LibraryService.filterByAuthor()
            .then(()=>{
                this.loadBooks()
            });
    }



}
export default App;
