import React from "react";
import {Link} from "react-router-dom";

const NavBar: React.FC = () => {
    return (
        <div className={ 'navbar navbar-expand-lg navbar-light bg-light' }>
            <div className={ 'container' }>
                <Link to={"/"}>HOME</Link>
            </div>
        </div>
    )
}

export default NavBar;