import React, {Component} from "react";
import BookTerm from "../BookTerm/bookTerm";
import BookFilter from "../BookFilter/bookFilter";
import {Link} from 'react-router-dom';
import ReactPaginate from "react-paginate";
import authors from "../../Authors/AuthorList/authors";


class Books extends React.Component{

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
        const pageCount=Math.ceil(this.props.books.length/this.state.size)
        const books=this.getBooksPage(offset,nextPageOffset);

      return(
          <div className={"container mm-4 mt-5"}>
              <div className={"row"}>


                  {/*<form id="filter-form ">*/}
                  {/*    <label htmlFor="f1">Author's name</label>*/}
                  {/*    <select id="f1" name="author">{authors}</select>*/}
                  {/*    <button id="filter" type="submit">Filter</button>*/}
                  {/*</form>*/}

                  {/*<form id="filter-form ">*/}
                  {/*    <label htmlFor="f1">Author's name</label>*/}
                  {/*    <select id="f1" name="author">*/}
                  {/*        /!* Map over authors to generate options *!/*/}
                  {/*        {authors.map((author) => (*/}
                  {/*            <option key={author.id} value={author.id}>*/}
                  {/*                {author.name}*/}
                  {/*            </option>*/}
                  {/*        ))}*/}
                  {/*    </select>*/}
                  {/*    <button id="filter" type="submit">Filter</button>*/}
                  {/*</form>*/}




                  <div className={"table-responsive"}>
                      <table className={"table table-striped"}>
                          <thead>
                          <tr>
                              <th scope={"col"}>Name</th>
                              <th scope={"col"}>Category</th>
                              <th scope={"col"}>Author</th>
                              <th scope={"col"}>AvailableCopies</th>
                          </tr>
                          </thead>
                          <tbody>
                          {books}
                          </tbody>
                      </table>
                  </div>
                  <div className="col mb-3">
                      <div className="row">
                          <div className="col-sm-12 col-md-12">
                              <Link className={"btn btn-block btn-dark"} to={"/add-book"}>Add new product</Link>
                          </div>
                      </div>
                  </div>
                  <ReactPaginate
                      previousLabel={"Previous"}
                      nextLabel={"Next"}
                      breakLabel={<a href="/#">...</a>}
                      breakClassName={"break-me"}
                      pageClassName={"ml-1"}
                      pageCount={Math.ceil(this.props.books.length/this.state.size)}
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

  getBooksPage = (offset, nextPageOffset) =>{
      return this.props.books.map((term) => {
              return (
                  term.category === "NOVEL" && term.availableCopies > 2 &&(
                  <BookTerm term={term} onDelete={this.props.onDelete} onEdit={this.props.onEdit} onRent={this.props.onRent}/>

              )
      );
          }).filter((book,index)=>{
              return index >= offset && index < nextPageOffset;
      })
  }
}

export default Books;