package e.sigare.opstalenthelp.Models

/**
 * Created by Said Murvatov on 22.03.2018.
 */
data class GenericRecyclerItem<T>(var item: T) {

    fun get(): T {
        return item
    }

}