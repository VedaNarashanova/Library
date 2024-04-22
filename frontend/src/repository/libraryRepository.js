import axios from "../custom-axios/axios";

const LibraryService={
    fetchAuthors:() =>{
        return axios.get("/authors");
    },
    fetchBooks:()=>{
        return axios.get("/books");
    },
    fetchCountries:()=>{
        return axios.get("/countries");
    },
    fetchCategories: () => {
        return axios.get("/books/categories");
    },
    deleteBook: (id) => {
        return axios.delete(`/delete-book/${id}`);
    },
    rentBook:(id) => {
        return axios.get(`/rent/${id}`);
    },
    addBook:(name,category,author,availableCopies)=>{
        return axios.post("/add-book",{
            "name":name,
            "category":category,
            "authorId":author,
            "availableCopies":availableCopies
        })
    },
    editBook:(id,name,category,author,availableCopies) => {
        return axios.post(`/edit-book/${id}`,{
            "name":name,
            "category":category,
            "authorId":author,
            "availableCopies":availableCopies
        });
    },
    getBook:(id)=>{
        return axios.get(`/book/${id}`);
    },

    addAuthor: (name, surname, country) => {
        return axios.post("/add-author",{
            "name": name,
            "surname": surname,
            "countryId": country

        });
    },
    deleteAuthor: (id) => {
        return axios.delete(`/delete-author/${id}`);
    },

    addCountry: (name, continent) => {
        return axios.post("/add-country", {
            "name":name,
            "continent":continent

        });
    },

    filterByAuthor:() =>{
        return axios.get("/books");
    },




}

export default LibraryService