import { Component } from 'react'
import { Switch, Route, Redirect, Link } from 'react-router-dom'
import Login from '../Login/Login'
import Register from '../Register/Register'
import Home from '../Home/Home'
import { addToken, deleteUser } from '../../Redux/actionCreators'
import { connect } from 'react-redux'
import { withRouter } from 'react-router-dom'
import Recipes from '../Recipes/Recipes'
import Create from '../Create/Create'
import Search from '../Search/Search'
import RecipeDetails from '../RecipeDetails/RecipeDetails'


const mapStateToProps = state => {
    return {
        token: state.token,
        user: state.user
    }
}

const mapDispatchToProps = (dispatch) => ({
    addToken: () => { dispatch(addToken()) },
    deleteUser: () => { dispatch(deleteUser()) }
});

class Main extends Component {
    constructor(props) {
        super(props);
    }

    handleLogout = () => {
        this.props.addToken("")
        this.props.deleteUser()
    }

    render() {
        const RecipeWithId = ({ match }) => {
            return <RecipeDetails id={match.params.id} />
        }

        return (
            <div>
                {this.props.token.token !== undefined ?
                    <div>
                        <Link to='/home'>Home | </Link>
                        <Link to='/recipes'>Recipes |</Link>
                        <Link to='/login' onClick={this.handleLogout}>logout</Link>
                        <Redirect to='/home' />

                    </div>
                    :
                    <div>
                        <Link to='/login'>Home | </Link>
                        {/* recipes on main for non logged in users? */}
                        <Link to='/recipes'>Recipes |</Link>
                    </div>
                }
                <Switch>
                    <Route path='/login' component={() => <Login />} />
                    <Route path='/register' component={() => <Register />} />
                    {/* <Route path='/recipes/:id' component={() => <RecipeDetails />} /> */}
                    {/* <Route path='/recipes/:id' component={RecipeDetails} /> */}
                    <Route exact path="/recipes/:id" component={RecipeWithId} />
                    <Route path='/recipes' component={() => <Recipes />} />
                    <Route path='/home' component={this.props.token.token !== undefined ? () => <Home /> : null} />

                    <Route path='/create' component={() => <Create />} />
                    <Route path="/search" component={() => <Search />} />


                    {/* <Route path="/search"><Search /></Route>
                    <Route path="/create"><Create /></Route>
                    <Route path='/recipes/:id'><RecipeDetails /></Route>
                    <Redirect to='/login' /> */}
                </Switch>
            </div>
        )
    }
}

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Main));