import React from 'react'
import { Link } from 'react-router-dom'
import axios from 'axios';

//styles
import './RecipesCardView.css'

export default function RecipesCardView({ recipes, handleClick }) {
    // export default function RecipesCardView({ recipes }) {

    var currentLocation = window.location.pathname;
    console.log('from recipes page ' + currentLocation)

    const handleDelete = (id) => {
        console.log(id)
        // axios.delete('http://localhost:3000/recipes', id)
        axios({
            method: 'DELETE',
            url: 'http://localhost:3000/recipes/' + id
        });
    }

    return (
        <div className='recipe-card-container'>
            {recipes.map((recipe, index) => (
                <div className='recipe-card-item' key={recipe.id}>
                    <h3>{index} - {recipe.title}</h3>
                    <p>{recipe.servings}</p>
                    <div className='recipe-instructions'>
                        {recipe.instructions.substring(0, 100)}...
                    </div>
                    <div className='recipe-card-buttons'>
                        {/* <button onClick={() => handleClick(recipe.id)}>delete recipe</button> */}
                        <button onClick={() => handleDelete(recipe.id)}>delete recipe</button>
                        <button>edit recipe</button>
                    </div>
                    <Link to={`/recipes/${recipe.id}`}>
                        View
                    </Link>
                </div>
            ))}
        </div>
    )
}
