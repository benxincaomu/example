import React, { Component } from 'react';
import { Tree } from 'antd';
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
        }, "json")
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
export default Grant;