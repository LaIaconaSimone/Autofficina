package com.example.autofficina.Services

import com.example.autofficina.Entity.Cliente

class ClienteService : IClienteServices{
    companion object {
        val clienteList: MutableList<Cliente> = mutableListOf(
            Cliente(0,"Andrea", "Verdi", "andrea.verdi@gmail.com"),
        )
    }

    override fun addCliente(cliente: Cliente){
        clienteList.add(cliente)
    }

    override fun getAllCliente(): List<Cliente> = clienteList
}
