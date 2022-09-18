import { useFetch } from '../../hooks/useFetch'
import './RecipeDetails.css'

export default function RecipeDetails(props) {

    const id = props.id
    const url = 'http://localhost:3000/recipes/' + id
    const { error, isPending, data: recipe } = useFetch(url)

    return (
        <div className="recipe-container">
            {error && <p className="error">{error}</p>}
            {isPending && <p className="loading">Loading...</p>}

            {recipe && (
                <div className="recipe-details">
                    <div class="recipe-section title-section" >
                        <h2>{recipe.title}</h2>
                    </div>
                    <div className="recipe-section time-section" >
                        <p>Prep Time: {recipe.prepTime.prepHrs && recipe.prepTime.prepHrs + " Hrs"} {recipe.prepTime.prepMins && recipe.prepTime.prepMins + " Mins"}
                        </p>
                        <p>Cook Time: {recipe.cookTime.cookHrs && recipe.cookTime.cookHrs + " Hrs"} {recipe.cookTime.cookMins && recipe.cookTime.cookMins + " Mins"}
                        </p>
                    </div>

                    <div className="recipe-section ingredients-section">
                        {recipe.ingredients && (
                            <ul>
                                {recipe.ingredients.map((ingredient) => {
                                    return (
                                        <li key={ingredient.note}>
                                            {ingredient.note}
                                        </li>
                                    )
                                })}
                            </ul>
                        )}
                    </div>

                    <div className="recipe-section instructions-section">
                        <p>{recipe.instructions}</p>
                    </div>
                    <div className="recipe-section bottom-section">
                        Created: mm/dd/yyy
                    </div>
                </div >
            )}
        </div>
    )
}
