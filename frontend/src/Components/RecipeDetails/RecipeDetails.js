// import { useParams } from 'react-router-dom'
import React, { useState } from 'react'
import { useFetch } from '../../hooks/useFetch'
import { withRouter } from "react-router"
import { matchPath } from 'react-router'
import { useEffect } from 'react'


//styles
import './RecipeDetails.css'

// const id = window.location.pathname;


//Recipe Detail View
export default function RecipeDetails(props) {

    console.log(props.id)
    var currentLocation = window.location.pathname;
    console.log('from recipes details ' + currentLocation)

    // var currentLocation = window.location.pathname;
    // console.log('from individual recipe' + currentLocation)

    // Can't use useParams because react-router-dom v4.2.2
    // const { id } = useParams();
    // const currentLocation = window.location.pathname;
    // console.log(currentLocation)

    // const ShowTheLocationWithRouter = withRouter(ShowTheLocation);
    // const currentRoute = matchPath(this.props.location.pathname)
    // console.log(`My current route key is : ${currentRoute.key}`)

    // console.log(this.props.location.pathname);


    // const url = 'http://localhost:3000/' + id
    // const { error, isPending, data: recipe } = useFetch(url)
    // console.log(url)
    // console.log(recipe)

    const [recipe, setRecipe] = useState([])
    // const { id } = this.props.id
    // console.log(id)

    // const id = this.props.match.params.id
    useEffect(() => {
        // const { id } = this.props.location.pathname
        const id = props.id


        fetch(`http://localhost:3000/recipes/${id}`)
            .then(response => response.json())
            .then(json => setRecipe(json))
    }, [])

    // fetch(`http://localhost:3000/recipes/${id}`)
    //     .then((recipe) => {
    //         this.setState(() => ({ recipe }))
    //     })


    // function componentDidMount() {
    //     const { id } = this.props.match.params

    //     fetch(`http://localhost:3000/recipes/${id}`)
    //         .then((recipe) => {
    //             this.setState(() => ({ recipe }))
    //         })
    // }


    return (
        <div className="recipe-detail">
            {/* {error && <p className="error">{error}</p>}
            {isPending && <p className="loading">Loading...</p>} */}
            {/* <h3>ID: {match.params.id}</h3> */}
            {/* <h3>ID: {this.props.match.params.id}</h3> */}
            {recipe && <h1>{recipe.title}</h1>}

        </div >
    )
}



// {recipe && (
//     <>
//         <h2 className="page-title">{recipe.title}</h2>
//          {/* <p>Takes {recipe.cookingTime} to cook.</p> */}
// <ul>
//     {recipe.ingredients.map(ing => <li key={ing}>ing</li>)}
// </ul>
// <p className="instructions">{recipe.instructions}</p>
// </>
// )
// }