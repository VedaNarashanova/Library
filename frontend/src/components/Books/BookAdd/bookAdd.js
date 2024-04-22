import React, {useState} from "react";
import {useNavigate} from 'react-router-dom';

const BookAdd = (props) => {

    const navigate = useNavigate();
    const [formData, updateFormData] = useState({
        name:"",
        category: props.categories.length >0 ? props.categories[0]: "",
        author: props.authors.length> 0 ? props.authors[0] : 1,
        availableCopies:0
    });

    // const handleChange=(e)=>{
    //     updateFormData({
    //         ...formData,
    //         [e.target.name]: e.target.value.trim()
    //     })
    // }
    const handleChange = (e) => {
        const { name, value } = e.target;

        // If the input name is country, find the selected country object
        if (name === 'author') {
            const selectedAuthor = props.authors.find(author => author.id === parseInt(value));
            updateFormData({
                ...formData,
                [name]: selectedAuthor // Store the entire country object
            });
        } else {
            // For other inputs (name and surname), update directly
            updateFormData({
                ...formData,
                [e.target.name]: e.target.value.trim()
            });
        }
    }


    const onFormSubmit=(e)=>{
        e.preventDefault()
        const name =formData.name
        const category =formData.category
        const author =formData.author
        const availableCopies =formData.availableCopies

        props.onAddBook(name,category,author,availableCopies);

        navigate("/books");
    }


    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Enter book name"
                               onChange={handleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label>Categories</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {props.categories.map((category) =>
                                <option key={category} value={category}>{category}</option>
                            )}
                        </select>
                    </div>

                    <div className="form-group">
                        <label>Author</label>
                        <select name="author" className="form-control" onChange={handleChange}>
                            {props.authors.map((term) =>
                                 <option value={term.id}>{term.name}</option>
                                // <option key={term.id} value={term.name.id}>{term.name}</option>
                            )}
                        </select>
                    </div>

                    <div className="form-group">
                        <label htmlFor="quantity">Available Copies</label>
                        <input type="number"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder="AvailableCopies"
                               required
                               onChange={handleChange}
                        />
                    </div>


                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>

    )


}
export default BookAdd;