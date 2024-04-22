import React from "react";

//funkcionalna
const categories =(props) =>{
    return(
        <div className={"container mm-4 mt-5"}>
            <h1>Categories</h1>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Category Name</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.categories.map((term) => {
                                return (
                                    <tr>
                                        <td>{term}</td>
                                    </tr>
                                );
                            }
                        )}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default categories;