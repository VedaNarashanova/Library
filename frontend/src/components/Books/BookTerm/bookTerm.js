import React from "react";
import {Link} from "react-router-dom";

//ova e za EDEN book
const bookTerm=(props) =>{

    return(
        <tr>
            <td scope={"col"}>{props.term.name}</td>
            <td scope={"col"}>{props.term.category}</td>
            <td scope={"col"}>{props.term.author.name} {props.term.author.surname}</td>
            <td scope={"col"}>{props.term.availableCopies}</td>
            <td scope={"col"} className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                    onClick={() => props.onDelete(props.term.id)}>
                    Delete</a>
                <Link title={"Edit"} className={"btn btn-info m-2"}
                    // pri klik se povikuva edit i se dodeluva id-to
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/edit-book/${props.term.id}`}>
                      Edit
                </Link>
                <a title={"Rent"} className={"btn btn-success m-2"}
                      onClick={() => props.onRent(props.term.id)}
                      to={`/rent/${props.term.id}`}>
                      Rent
                </a>
            </td>
        </tr>


    )
}

export default bookTerm;

// {/*<form>*/}
// {/*    <div className="form-group">*/}
// {/*        <select id="author">*/}
// {/*/!*            // onChange={(e) => props.onSelectAuthor(e.target.value)}*!/*/}
// {/*/!*            >*!/*/}
// {/*/!*            {props.authors.map((author) => (*!/*/}
// {/*/!*                <option key={author.id} value={author.id}>*!/*/}
// {/*/!*                    {author.name}*!/*/}
// {/*/!*                </option>*!/*/}
// {/*/!*            ))}*!/*/}
// {/*        </select>*/}
// {/*    </div>*/}
// {/*    <div className="form-group">*/}
// {/*        <select id="author">*/}
// {/*            {Array.isArray(props.authors) &&*/}
// {/*                props.authors.map((author) => (*/}
// {/*                    <option key={author.id} value={author.id}>*/}
// {/*                        {author.name}*/}
// {/*                    </option>*/}
// {/*                ))}*/}
// {/*        </select>*/}
// {/*    </div>*/}
// {/*    <a title={"Filter"} className={"btn btn-danger"}*/}
// {/*       onClick={() => props.onFilter(props.term.id)}>*/}
// {/*        Filter</a>*/}
