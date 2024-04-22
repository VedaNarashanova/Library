import React, {useState} from "react";
import {useNavigate} from 'react-router-dom';

const CountryAdd = (props) => {

    const navigate = useNavigate();
    const [formData, updateFormData] = useState({
        name:"",
        continent:""
    });

    const handleChange=(e)=>{
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit=(e)=>{
        e.preventDefault()
        const name =formData.name
        const continent =formData.continent


        props.onAddCountry(name,continent);

        navigate("/countries");
    }


    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Country name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Enter country name"
                               onChange={handleChange}
                        />
                    </div>

                    {/*<div className="form-group">*/}
                    {/*    <label>Author</label>*/}
                    {/*    <select name="author" className="form-control" onChange={handleChange}>*/}
                    {/*        {props.authors.map((term) =>*/}
                    {/*            <option value={term.id}>{term.name}</option>*/}
                    {/*        )}*/}
                    {/*    </select>*/}
                    {/*</div>*/}

                    <div className="form-group">
                        <label htmlFor="continent">Continent</label>
                        <input type="text"
                               className="form-control"
                               id="continent"
                               name="continent"
                               placeholder="Continent"
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
export default CountryAdd ;