import React from "react";
import {Link} from "react-router-dom";

//ova e za EDEN book
const bookFilter=(props) =>{

    return(
        <form>
            <div className="form-group">*/}
                         <select id="author">
                              {/*onChange={(e) => props.onSelectAuthor(e.target.value)}*/}
                             {props.authors.map((author) => (
                                 <option key={author.id} value={author.id}>
                                     {author.name}
                                 </option>
                             ))}
                         </select>
                     </div>
        </form>

    )
}

export default bookFilter;