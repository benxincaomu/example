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
            selectNode: [],
            rolePermissions:[]
        }
        this.eachPermission=this.eachPermission.bind(this);
        this.getAllPermissions=this.getAllPermissions.bind(this);
    }
    componentWillMount() {
        this.getAllPermissions();
        this.query(this.props.id);
    }
    componentWillReceiveProps(props) {
        if (!props.id) {
            this.resetState();
            return;
        }
        if (props.id === this.state.id) {
            return;
        }
        
        this.query(props.id);
    }
    getAllPermissions(){
        $.get("/web/role/permissions", {}, (data) => {
            this.setState({ permissions: data })
        }, "json");
    }
    query(id) {
        if (id) {
            $.get("./web/role/getRole", { id: id }, (data) => {
                this.setState({ roleId: id});
                let rolePermissions=data.permissions;
                let perArry=[];
                rolePermissions.map((permission,index)=>{
                    perArry.push(permission.id);
                })
                this.setState({rolePermissions:perArry})
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
        return (<Tree defaultValue={this.state.perArry} checkable >
                {this.eachPermission(this.state.permissions)}
        </Tree>);
    }
}
Grant.propTypes={
    id: PropTypes.string
}
export default Grant;