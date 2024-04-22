import {useNavigate} from "react-router-dom";
import React, {useState} from "react";

const AuthorAdd = (props) => {

    const navigate = useNavigate();
    const [formData, updateFormData] = useState({
        name:"",
        surname:"",
        country : props.countries.length > 0 ? props.countries[0] : 1,
    });

    // const handleChange=(e)=>{
    //     updateFormData({
    //         ...formData,
    //         [e.target.name]: e.target.value.trim()
    //     })
    // }

    // const handleChange = (e) => {
    //     const { name, value } = e.target;
    //
    //     // Find the selected country object based on its id
    //     const selectedCountry = props.countries.find(country => country.id === parseInt(value));
    //
    //     updateFormData({
    //         ...formData,
    //         [name]: selectedCountry // Store the entire country object
    //     });
    // }

    const handleChange = (e) => {
        const { name, value } = e.target;

        // If the input name is country, find the selected country object
        if (name === 'country') {
            const selectedCountry = props.countries.find(country => country.id === parseInt(value));
            updateFormData({
                ...formData,
                [name]: selectedCountry // Store the entire country object
            });
        } else {
            // For other inputs (name and surname), update directly
            updateFormData({
                ...formData,
                [name]: value.trim()
            });
        }
    }
    const onFormSubmit=(e)=>{
        e.preventDefault()
        const name =formData.name
        const surname =formData.surname
        const country =formData.country

        props.onAddAuthor(name,surname,country);

        navigate("/authors");
    }


    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Author name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Enter author name"
                               onChange={handleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="surname">Surname</label>
                        <input type="text"
                               className="form-control"
                               id="surname"
                               name="surname"
                               placeholder="Surname"
                               required
                               onChange={handleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label>Country</label>
                        <select name="country" className="form-control" onChange={handleChange}>
                            {props.countries.map((term) =>
                                <option value={term.id}>{term.name}</option>
                            )}
                        </select>
                    </div>

                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>

    )


}
export default AuthorAdd;