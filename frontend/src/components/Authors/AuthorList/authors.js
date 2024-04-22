import React, {Component} from "react";
import {Link} from 'react-router-dom';
import ReactPaginate from "react-paginate";
import AuthorTerm from "../AuthorTerm/authorTerm";


class Authors extends React.Component{

    constructor(props) {
        super(props);


        this.state={
            page:0,
            size:2
        }
    }

    render(){

        const offset = this.state.size * this.state.page
        const nextPageOffset=offset+this.state.size
        const pageCount=Math.ceil(this.props.authors.length/this.state.size)
        const authors=this.getAuthorPage(offset,nextPageOffset);

        return(
            <div className={"container mm-4 mt-5"}>
                <div className={"row"}>
                    <div className={"table-responsive"}>
                        <table className={"table table-striped"}>
                            <thead>
                            <tr>
                                <th scope={"col"}>Name</th>
                                <th scope={"col"}>Surname</th>
                                <th scope={"col"}>Country</th>
                            </tr>
                            </thead>
                            <tbody>
                            {authors}
                            </tbody>
                        </table>
                    </div>
                    <div className="col mb-3">
                        <div className="row">
                            <div className="col-sm-12 col-md-12">
                                <Link className={"btn btn-block btn-dark"} to={"/add-author"}>Add new Author</Link>
                            </div>
                        </div>
                    </div>
                    <ReactPaginate
                        previousLabel={"Previous"}
                        nextLabel={"Next"}
                        breakLabel={<a href="/#">...</a>}
                        breakClassName={"break-me"}
                        pageClassName={"ml-1"}
                        pageCount={Math.ceil(this.props.authors.length/this.state.size)}
                        marginPagesDisplayed={2}
                        pageRangeDisplayed={5}
                        onPageChange={this.handlePageClick}
                        containerClassName={"pagination m-4 justify-content-center"}
                        activeClassName={"active"}/>
                </div>
            </div>
        );
    }

    handlePageClick=(data)=>{
        let selected=data.selected;
        this.setState({
            page: selected
        })
    }


    getAuthorPage = (offset, nextPageOffset) =>{
        return this.props.authors.map((term) => {
            return (
                <AuthorTerm term={term} onDelete={this.props.onDelete}/>
            );
        }).filter((author,index)=>{
            return index >= offset && index < nextPageOffset;
        })
    }
    // getAuthorPage = (offset, nextPageOffset) => {
    //     return this.props.authors
    //         .slice(offset, nextPageOffset)
    //         .map((term) => (
    //             <tr key={term.id}>
    //                 <td>{term.name}</td>
    //                 <td>{term.surname}</td>
    //                 <td>{term.country.id}</td>
    //                 <td>
    //                     <button  onClick={() => props.onDelete(props.term.id)} className="btn btn-danger">Delete</button>
    //                 </td>
    //             </tr>
    //         ));
    // }
}

export default Authors;


// import React from "react";
// import {Link} from "react-router-dom";
//
// //funkcionalna
// const authors =(props) =>{
//     return(
//       <div className={"container mm-4 mt-5"}>
//           <div className={"row"}>
//               <div className={"table-responsive"}>
//                   <table className={"table table-striped"}>
//                       <thead>
//                          <tr>
//                              <th scope={"col"}>Name</th>
//                              <th scope={"col"}>Surname</th>
//                              <th scope={"col"}>Country</th>
//                           </tr>
//                       </thead>
//                       <tbody>
//                       {props.authors.map((term) => {
//                               return (
//                                   <tr>
//                                       <td>{term.name}</td>
//                                       <td>{term.surname}</td>
//                                       <td>{term.country.name}</td>
//                                   </tr>
//                               );
//                           }
//                       )}
//                       </tbody>
//                   </table>
//               </div>
//               <div className="col mb-3">
//                   <div className="row">
//                       <div className="col-sm-12 col-md-12">
//                           <Link className={"btn btn-block btn-dark"} to={"/add-author"}>Add new author</Link>
//                       </div>
//                   </div>
//               </div>
//           </div>
//       </div>
//     );
// }
//
// export default authors;