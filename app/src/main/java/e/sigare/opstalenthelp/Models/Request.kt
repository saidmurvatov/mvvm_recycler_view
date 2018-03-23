package e.sigare.opstalenthelp.Models

/**
 * Created by Said Murvatov on 16.03.2018.
 */

data class Model(var content: String, var name: String, var done: Boolean) : IModel

interface IModel