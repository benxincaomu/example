import React from "react"
import PropTypes from 'prop-types';
export class Component extends React.Component {
    render() {
        return <div>{this.props.text}</div>;
    }
}
Component.propTypes = {
  text: PropTypes.string.isRequired
};