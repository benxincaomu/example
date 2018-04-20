import React, { Component } from 'react';
import { Tree } from 'antd';
import PropTypes from 'prop-types'
import $ from 'jquery'

const TreeNode = Tree.TreeNode;
class Grant extends Component {
    constructor(props) {
        super(props);
        this.state = {
            permissions: [],
            selectNode: []
        }
        this.eachPermission=this.eachPermission.bind(this);
    }
    componentWillMount() {
        $.get("/web/role/permissions", {}, (data) => {
            this.setState({ permissions: data })
        }, "json");
        this.query(this.props.id);
    }
    componentWillReceiveProps(props) {
        if (!props.id) {
            this.resetState();
            // this.props.form.resetFields();
            return;
        }
        if (props.id === this.state.id) {
            return;
        }

        this.query(props.id);
    }
    query(id) {
        if (id) {

            $.get("./web/role/getRole", { id: id }, (data) => {
                this.setState({ roleId: id, permissions: data.permissions });
            }, "json");
        }
    }
    eachPermission(permissions){
        return permissions.map((permission,index)=>{
            return <TreeNode  key={permission.id} title={permission.name} >
                {permission.subPermissions&&permission.subPermissions.length&&this.eachPermission(permission.subPermissions)}
            </TreeNode>
        })
    }
    render() {
        return (<Tree checkable>
                {this.eachPermission(this.state.permissions)}
        </Tree>);
    }
}
Grant.propTypes={
    id: PropTypes.string
}
export default Grant;