//styles
import './RecipesListView.css'


export default function RecipesListView({ recipes, handleClick }) {

    // fetch(' http://localhost:3000/recipes')
    //     .then(response => response.json())
    //     .then(json => console.log(json))

    // managing recipe state in Recipes vs here (would remove events from parameter)
    // const [events, setEvents] = useState()
    // useEffect(() => {
    //     fetch(' http://localhost:3000/recipes')
    //         .then(response => response.json())
    //         .then(json => setEvents(json))
    // }, [])
    // console.log(events)

    return (
        <div className='recipe-list-container'>
            {recipes.map((recipe, index) => (
                <div className='recipe-list-item' key={recipe.id}>
                    <h3>{index} - {recipe.title}</h3>
                    <div className='recipe-list-buttons'>
                        <button onClick={() => handleClick(recipe.id)}>delete recipe</button>
                        <button>edit recipe</button>
                    </div>
                </div>
            ))}
        </div>
    )
}
