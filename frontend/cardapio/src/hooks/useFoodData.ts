import { useQuery } from "@tanstack/react-query";
import { AxiosPromise } from "axios"
import Api from "../api/axios-config" 
import { FoodData } from "../interface/FoodData";

const fetchData = async (): AxiosPromise<FoodData[]> => {
    const response = Api.get('/food');
    return response
}

export function useFoodData() {
    const query = useQuery({
        queryFn: fetchData,
        queryKey: ['food-data'],
        retry: 2
    });

    return {
        ...query,
        data: query.data?.data
    }
}