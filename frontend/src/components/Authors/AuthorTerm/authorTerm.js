import React from "react";
import {Link} from "react-router-dom";

//ova e za EDEN book
const authorTerm=(props) =>{

    return(
        <tr>
            <td scope={"col"}>{props.term.name}</td>
            <td scope={"col"}>{props.term.surname}</td>
            <td scope={"col"}>{props.term.country.name}</td>
            <td scope={"col"} className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id)}>
                    Delete
                </a>
            </td>
        </tr>
    )
}

export default authorTerm;